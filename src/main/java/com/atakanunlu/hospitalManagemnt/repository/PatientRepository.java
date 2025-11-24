package com.atakanunlu.hospitalManagemnt.repository;

import com.atakanunlu.hospitalManagemnt.dto.BloodGroupCountResponseEntity;
import com.atakanunlu.hospitalManagemnt.entity.Patient;
import com.atakanunlu.hospitalManagemnt.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String name);


    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("SELECT NEW com.atakanunlu.hospitalManagemnt.dto.BloodGroupCountResponseEntity(p.bloodGroup, COUNT(p)) FROM Patient p GROUP BY p.bloodGroup")
    //List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "SELECT * FROM Patient",nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);


    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name") String name , @Param("id") Long id);




}