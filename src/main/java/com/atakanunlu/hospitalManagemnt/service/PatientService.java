package com.atakanunlu.hospitalManagemnt.service;

import com.atakanunlu.hospitalManagemnt.entity.Patient;
import com.atakanunlu.hospitalManagemnt.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {


    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){


        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1 == p2);

        p1.setName("Atakans");

        return p1;
    }

}
