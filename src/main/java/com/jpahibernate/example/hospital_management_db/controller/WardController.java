package com.jpahibernate.example.hospital_management_db.controller;

import com.jpahibernate.example.hospital_management_db.model.Ward;
import com.jpahibernate.example.hospital_management_db.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ward/apis")
public class WardController {

    @Autowired
    WardService wardService;

    @PostMapping("/save")
    public String saveWard(@RequestBody Ward ward) {
        String response = wardService.addWard(ward);
        return response;
    }
}
