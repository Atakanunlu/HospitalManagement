package com.atakanunlu.hospitalManagemnt.repository;

import com.atakanunlu.hospitalManagemnt.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
