package com.jpahibernate.example.hospital_management_db.repository;

import com.jpahibernate.example.hospital_management_db.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository    // it performs the database operations and it is the data layer
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
