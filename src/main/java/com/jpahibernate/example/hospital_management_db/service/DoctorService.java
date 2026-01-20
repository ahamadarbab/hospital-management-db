package com.jpahibernate.example.hospital_management_db.service;

import com.jpahibernate.example.hospital_management_db.model.Doctor;
import com.jpahibernate.example.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // it contains the business logic
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "Doctor saved Successfully!";
    }

    public List<Doctor> findAllDoctors() {
        List<Doctor> doctorsList = doctorRepository.findAll();
        return doctorsList;
    }

    public Doctor findDoctorById(int id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent())
        {
            return doctorOptional.get();
        }
        else
        {
            return null;
        }
    }

    public String deleteDoctorById(int id) {
        doctorRepository.deleteById(id);
        return "Doctor with id : " + id + " got deleted successfully!!";
    }

    public String countDoctor() {
        long totalCount = doctorRepository.count();
        return "Total doctors present are : " + totalCount;
    }
}
