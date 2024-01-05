package com.aditya.employees.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private  String department;
    private String address;
    private String phone;

    public  Employee () {}
    public Employee(Long id, String name, String department, String address, String phone) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
        this.phone = phone;
    }
}
