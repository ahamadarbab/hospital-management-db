package com.jpahibernate.example.hospital_management_db.service;

import com.jpahibernate.example.hospital_management_db.model.Ward;
import com.jpahibernate.example.hospital_management_db.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // it contains the business logic
public class WardService {

    @Autowired
    WardRepository wardRepository;

    public String addWard(Ward ward) {
        wardRepository.save(ward);
        return "Ward saved successfully!";
    }
}
