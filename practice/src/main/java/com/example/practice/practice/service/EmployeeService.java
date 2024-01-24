package com.example.practice.practice.service;

import com.example.practice.practice.entity.dto.EmployeeDto;
import com.example.practice.practice.entity.dto.ResetPasswordDto;
import com.example.practice.practice.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    public Employee createEmployee(Employee employee);

    public ResponseEntity<EmployeeDto> getEmployeeById(long employeeId);

    Optional<Employee> updateEmployee(long employeeId, Employee employee);

    public ResponseEntity<String> deleteEmployee(long employeeId);

    public List<Employee> getAllEmployees();

    public ResponseEntity<String> resetPassword(ResetPasswordDto resetPasswordDto);
}

