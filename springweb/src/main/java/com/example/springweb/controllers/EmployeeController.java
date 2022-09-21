package com.example.springweb.controllers;


import com.example.springweb.dtos.EmployeeDto;
import com.example.springweb.models.Employee;
import com.example.springweb.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") long id){
        return employeeService.getEmployee(id);
    }
    @PostMapping
    public void addEmployee(@RequestBody EmployeeDto employee){
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable("id") long id , @RequestBody EmployeeDto employee){
        employeeService.updateEmployee(id,employee);
    }
}
