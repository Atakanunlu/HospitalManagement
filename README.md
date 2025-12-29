````md
# 🏥 Hospital Management API (Spring Boot + PostgreSQL)
Modern bir hastane yönetim backend projesi. Hasta (Patient), Doktor (Doctor), Randevu (Appointment), Departman (Department) ve Sigorta (Insurance) süreçlerini **REST API mantığı + JPA ilişkileri** üzerinden yönetmeyi hedefler.

---

## ✨ Özellikler

### 👤 Patient (Hasta) Modülü
- Hasta oluşturma / listeleme / detay görüntüleme (Repo & Service)
- İsme göre arama:
  - `findByName`
  - `findByNameContainingOrderByIdDesc`
- Doğum tarihi ve email ile filtreleme:
  - `findByBirthDateOrEmail`
  - `findByBirthDateBetween`
  - `findByBornAfterDate`
- Kan grubuna göre listeleme:
  - `findByBloodGroup`
- 🩸 Kan grubu dağılımı (DTO ile):
  - `countEachBloodGroupType()` → `BloodGroupCountResponseEntity(bloodGroupType, count)`
- 📄 Pagination / Sorting (Pageable):
  - `findAllPatient(Pageable pageable)`
- ✏️ Update sorgusu:
  - `updateNameWithId(name, id)` (JPQL UPDATE)

### 🗓️ Appointment (Randevu) Modülü
- Yeni randevu oluşturma:
  - `createNewAppointment(appointment, doctorId, patientId)`
- Randevuyu başka doktora aktarma:
  - `reAssignAppointmentToAnotherDoctor(appointmentId, doctorId)`
- Hasta ↔ Doktor ↔ Randevu ilişkileri otomatik yönetilir.

### 🧾 Insurance (Sigorta) Modülü
- Hastaya sigorta atama:
  - `assignInsuranceToPatient(insurance, patientId)`
- Hastadan sigortayı ayırma:
  - `disaccociateInsuranceFromPatient(patientId)`

### 🏢 Department (Departman) Modülü
- Departman sorumlusu doktor (headDoctor) tanımlama (OneToOne)
- Departman ↔ Doktor ilişkisi (ManyToMany, join table: `my_dpt_doctors`)

---

## 🧬 Veri Modeli ve İlişkiler
- Patient ↔ Insurance: **OneToOne**
- Patient ↔ Appointment: **OneToMany**
- Doctor ↔ Appointment: **OneToMany**
- Department ↔ Doctor: **ManyToMany**
- Department → headDoctor: **OneToOne**

---

## 🧰 Teknolojiler
- ☕ Java
- 🌱 Spring Boot
- 🧬 Spring Data JPA (Hibernate)
- 🐘 PostgreSQL
- 🧾 Lombok
- 🧪 JUnit (SpringBootTest)

---

## 🚀 Kurulum ve Çalıştırma

### ✅ Gereksinimler
- Java
- Maven
- PostgreSQL

### 🗄️ Veritabanı
PostgreSQL’de veritabanı oluştur:
```sql
CREATE DATABASE hospital_management;
````

### ⚙️ application.properties

`src/main/resources/application.properties` içine DB ayarlarını gir:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_management
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### ▶️ Çalıştırma

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🧪 Testler

Proje fonksiyonları testlerle gösterilmiştir:

* `InsuranceTest`

  * Sigorta atama / ayırma
  * Randevu oluşturma + doktor değiştirme
* `PatientTests`

  * Fetch join ile hasta + randevular
  * Pagination/Sort örneği
  * Kan grubu count DTO

Test çalıştır:

```bash
mvn test
```

---

## 🗃️ Örnek Seed Data

Hasta, doktor ve randevu için örnek SQL insert’leri kullanılmıştır:

* `patient`
* `doctor`
* `appointment`

---

## 📌 Proje Yapısı (Kısa)

* `entity/` 🧱 JPA Entity’ler
* `entity/type/` 🧾 Enum’lar (BloodGroupType)
* `repository/` 🗄️ DB erişimi (JpaRepository + Query)
* `service/` 🧠 İş mantığı
* `dto/` 📦 Response DTO’ları
* `test/` 🧪 SpringBootTest senaryoları

```
