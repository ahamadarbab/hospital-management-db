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

    // update using put operation - updates complete object
    public String updateDoctorUsingPut(int id, Doctor newDoctorRequest) {
        // find the doctor with id
        // if doctor is present update it
        // else we cannot update
        Doctor existingDoctor = findDoctorById(id);
        if(existingDoctor != null)
        {
            // proceed with update
            doctorRepository.save(newDoctorRequest);
            return "Doctor updated successfully!";
        }
        else
        {
            // cannot update
            return "Doctor with id : " + id + " is not present, hence cannot update";
        }
    }

    // update using patch operation - updates single specific fields
    public String updateDoctorUsingPatch(int id, String newName, String newEmail, String newPhone) {
        // find the doctor with id
        // if the doctor is present update it
        // else we can not update
        Doctor existingDoctor = findDoctorById(id);
        if(existingDoctor != null)
        {
            // proceed with update
            existingDoctor.setName(newName);
            existingDoctor.setEmail(newEmail);
            existingDoctor.setPhone(newPhone);
            doctorRepository.save(existingDoctor);
            return "Doctor updated successfully!";
        }
        else
        {
            // cannot update
            return "Doctor with id : " + id + " is not present, hence cannot update";
        }
    }
}
