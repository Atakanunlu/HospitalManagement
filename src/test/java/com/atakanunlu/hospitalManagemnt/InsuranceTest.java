package com.atakanunlu.hospitalManagemnt;

import com.atakanunlu.hospitalManagemnt.entity.Appointment;
import com.atakanunlu.hospitalManagemnt.entity.Insurance;
import com.atakanunlu.hospitalManagemnt.entity.Patient;
import com.atakanunlu.hospitalManagemnt.service.AppointmentService;
import com.atakanunlu.hospitalManagemnt.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    public InsuranceService insuranceService;

    @Autowired
    public AppointmentService appointmentService;

    @Test
    public void testInsurance(){

        Insurance insurance = Insurance.builder()
                .policyNumber("POL-12345")
                .provider("Axa Sigorta")
                .validUntil(LocalDate.of(2025,12,31))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 12,28,14,40))
                .reason("Cancer")
                .build();
        var newAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(newAppointment);
    }


}
