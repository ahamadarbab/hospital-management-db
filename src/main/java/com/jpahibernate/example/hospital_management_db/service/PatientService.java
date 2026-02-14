package com.jpahibernate.example.hospital_management_db.service;

import com.jpahibernate.example.hospital_management_db.model.Doctor;
import com.jpahibernate.example.hospital_management_db.model.Patient;
import com.jpahibernate.example.hospital_management_db.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // it contains the business logic
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public String addPatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient saved successfully!";
    }

    public List<Patient> findAllPatients() {
        List<Patient> patientsList = patientRepository.findAll();
        return patientsList;
    }
}
