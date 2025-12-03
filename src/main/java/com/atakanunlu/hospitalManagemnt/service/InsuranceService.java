package com.atakanunlu.hospitalManagemnt.service;

import com.atakanunlu.hospitalManagemnt.repository.InsuranceRepository;
import com.atakanunlu.hospitalManagemnt.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;



}
