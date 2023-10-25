package com.example.practice.practice.service;

import com.example.practice.practice.dto.EmployeeDto;
import com.example.practice.practice.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface EmployeeService {
    public Employee createEmployee(Employee employee);

    public ResponseEntity<EmployeeDto> getEmployeeById(long employeeId);


    Optional<Employee> updateEmployee(long employeeId, Employee employee);
}
