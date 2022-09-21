package com.example.springweb.services;

import com.example.springweb.dtos.EmployeeDto;
import com.example.springweb.dtos.SkillDto;
import com.example.springweb.models.Employee;
import com.example.springweb.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SkillService skillService;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public void addEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setDob(employeeDto.getDob());
        employee.setEmail(employeeDto.getEmail());
        for (SkillDto skill: employeeDto.getSkillset()) {
            employee.getSkillset().add(skillService.getSkill(skill.getId()));
        }
        employeeRepository.save(employee);
    }
    public Employee getEmployee(long id){
        return employeeRepository.findById(id).get();
    }
    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }
    public void updateEmployee(long id , EmployeeDto newEmployeeDto){
        Employee employee = getEmployee(id);
        employee.setName(newEmployeeDto.getName());
        employee.setEmail(newEmployeeDto.getEmail());
        employee.setDob(newEmployeeDto.getDob());
        employee.setSkillset(new HashSet<>());
        for (SkillDto skill: newEmployeeDto.getSkillset()) {
            employee.getSkillset().add(skillService.getSkill(skill.getId()));
        }
        employeeRepository.save(employee);
    }
}
