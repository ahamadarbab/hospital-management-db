package com.jpahibernate.example.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity    // it represents that this class is entity or model class which is directly creating the database table
@Table(name = "patients")    // it will create a table inside database
@Data    // it will add the getters and setters
@AllArgsConstructor    // it will add the parameterized constructor
@NoArgsConstructor    // it will add the default constructor
public class Patient {

    @Id    // it is the primary key of the table - it will be unique and it is not null
    @Column(name = "patient_id")    // it will create a column inside database table
    private int patientId;

    @Column(name = "patient_name", nullable = false)    // nullable = false - it cannot contain null value
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone", nullable = false, unique = true)
    private int phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "disease", nullable = false)
    private String disease;

    @Column(name = "admission_date", nullable = false)
    private String admissionDate;

    @Column(name = "admitted", nullable = false)
    private boolean admitted;
}
