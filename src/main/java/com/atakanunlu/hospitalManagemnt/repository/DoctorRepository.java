package com.atakanunlu.hospitalManagemnt.repository;

import com.atakanunlu.hospitalManagemnt.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}