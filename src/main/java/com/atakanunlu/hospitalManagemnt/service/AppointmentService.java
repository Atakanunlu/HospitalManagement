package com.atakanunlu.hospitalManagemnt.service;

import com.atakanunlu.hospitalManagemnt.entity.Appointment;
import com.atakanunlu.hospitalManagemnt.entity.Doctor;
import com.atakanunlu.hospitalManagemnt.entity.Patient;
import com.atakanunlu.hospitalManagemnt.repository.AppointmentRepository;
import com.atakanunlu.hospitalManagemnt.repository.DoctorRepository;
import com.atakanunlu.hospitalManagemnt.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: " + doctorId));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        if (appointment.getId() != null) {
            throw new IllegalArgumentException("Appointment should not have ID");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + appointmentId));

        Doctor newDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id: " + doctorId));

        Doctor oldDoctor = appointment.getDoctor();
        if (oldDoctor != null) {
            oldDoctor.getAppointments().remove(appointment);
        }

        appointment.setDoctor(newDoctor);
        newDoctor.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }
}