package com.jpahibernate.example.hospital_management_db.controller;

import com.jpahibernate.example.hospital_management_db.model.Doctor;
import com.jpahibernate.example.hospital_management_db.repository.DoctorRepository;
import com.jpahibernate.example.hospital_management_db.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    // debugging - tracing the flow of the application(understanding line by line what is happening)

    // spring boot application - takes input in the form of JSON(javascript object notation)

    // @RequestBody - it is used to take input from UI or postman, and it is used for only complete class inputs

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor) {
        String response = doctorService.addDoctor(doctor);
        return response;
    }

    @GetMapping("/findAll")
    public List<Doctor> findAllDoctor() {
        List<Doctor> doctorList = doctorService.findAllDoctors();
        return doctorList;
    }

    // @PathVariable - it is used to take the inputs in input request url path
    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id) {
        Doctor doctor = doctorService.findDoctorById(id);
        return doctor;
    }

    @GetMapping("/count")
    public String countDoctors() {
        String response = doctorService.countDoctor();
        return response;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteDoctorById(@PathVariable int id) {
        String response = doctorService.deleteDoctorById(id);
        return response;
    }
}
