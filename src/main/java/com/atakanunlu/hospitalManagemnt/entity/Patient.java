package com.atakanunlu.hospitalManagemnt.entity;

import com.atakanunlu.hospitalManagemnt.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient",
   uniqueConstraints = {
        //@UniqueConstraint(name = "unique_patient_email", columnNames={"email"}),
        @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name","birthDate"})
   },
        indexes = {
        @Index(name = "idx_patient_birth_date", columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 40)
    private String name;

    //@ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

}