package com.atakanunlu.hospitalManagemnt;

import com.atakanunlu.hospitalManagemnt.dto.BloodGroupCountResponseEntity;
import com.atakanunlu.hospitalManagemnt.entity.Patient;
import com.atakanunlu.hospitalManagemnt.entity.type.BloodGroupType;
import com.atakanunlu.hospitalManagemnt.repository.PatientRepository;
import com.atakanunlu.hospitalManagemnt.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);



    }


    @Test
    public void testTransactionMethod(){
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);


//        Patient patient = patientRepository.findByName("Atakan2");
//        System.out.println(patient);


//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(2001,10,2),"aa1@gmail.com");
//        for (Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("At");
//        for (Patient patient: patientList){
//            System.out.println(patient);
//        }

//        List<Patient> findBloodGroup = patientRepository.findByBloodGroup(BloodGroupType.O_POSITIVE);
//        for (Patient patient: findBloodGroup){
//            System.out.println(patient);
//        }

//        List<Patient> findBornAfterDate = patientRepository.findByBornAfterDate(LocalDate.of(2000,11,12));
//        for (Patient patient: findBornAfterDate){
//            System.out.println(patient);
//        }
//
//        List<Object[]> countEachBloodGroupType = patientRepository.countEachBloodGroupType();
//        for (Object[] objects: countEachBloodGroupType){
//            System.out.println(objects[0] + " " + objects[1]);
//        }
//
//        List<Patient> patientList = patientRepository.findAllPatient();
//        for (Patient patient: patientList){
//            System.out.println(patient);
//        }

//        int rowsUpdated = patientRepository.updateNameWithId("Atakan Ünlü",1L);
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList){
//            System.out.println(bloodGroupCountResponse);
//        }

        Page<Patient> patientList = patientRepository.findAllPatient(PageRequest.of(0,2, Sort.by("name")));
        for (Patient patient: patientList){
            System.out.println(patient);
        }

    }


}