package com.atakanunlu.hospitalManagemnt.repository;

import com.atakanunlu.hospitalManagemnt.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
