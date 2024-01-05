package com.aditya.employees.service;

import com.aditya.employees.Exceptions.UserNotFoundException;
import com.aditya.employees.model.Employee;
import com.aditya.employees.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
    return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
    return employeeRepo.findAll();
    }

    public Employee findEmployee(Long id){
    return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Employee does not exist"));
    }

    public Employee updateEmployee(Employee employee){
    return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
    employeeRepo.deleteById(id);
    }
}
