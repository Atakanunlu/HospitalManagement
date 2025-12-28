package com.atakanunlu.hospitalManagemnt.service;

import com.atakanunlu.hospitalManagemnt.entity.Appointment;
import com.atakanunlu.hospitalManagemnt.entity.Doctor;
import com.atakanunlu.hospitalManagemnt.entity.Patient;
import com.atakanunlu.hospitalManagemnt.repository.AppointmentRepository;
import com.atakanunlu.hospitalManagemnt.repository.DoctorRepository;
import com.atakanunlu.hospitalManagemnt.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId , Long patientId){

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if (appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

}
