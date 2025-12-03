package com.atakanunlu.hospitalManagemnt.repository;

import com.atakanunlu.hospitalManagemnt.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}