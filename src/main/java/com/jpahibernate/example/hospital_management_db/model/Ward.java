package com.jpahibernate.example.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity    // it represents that this class is entity or model class which is directly creating the database table
@Table(name = "wards")    // it will create a table inside database
@Data    // it will add the getters and setters
@AllArgsConstructor    // it will add the parameterized constructor
@NoArgsConstructor    // it will add the default constructor
public class Ward {

    @Id    // it is the primary key of the table - it will be unique and it is not null
    @Column(name = "ward_id")    // it will create a column inside database table
    private int wardId;

    @Column(name = "ward_number", nullable = false, unique = true)    // nullable = false - it cannot contain null value
    private String wardNumber;

    @Column(name = "ward_type", nullable = false)
    private String wardType;    // General, ICU, Private

    @Column(name = "total_beds", nullable = false)
    private int totalBeds;

    @Column(name = "available_beds", nullable = false)
    private int availableBeds;

}
