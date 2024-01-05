package com.aditya.employees;

import com.aditya.employees.model.Employee;
import com.aditya.employees.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class controller {
    private final EmployeeService employeeService;

    public controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> sortedEmployees = employeeService.findAllEmployees().
                stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(employeeService.findAllEmployees());
        System.out.println(sortedEmployees);
        return new ResponseEntity<>(sortedEmployees, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.findEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        return  new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
