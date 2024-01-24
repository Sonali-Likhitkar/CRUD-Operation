package com.example.practice.practice.util;

import com.example.practice.practice.entity.dto.EmployeeDto;
import com.example.practice.practice.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeConverter {


    public static Employee convertToEntity(EmployeeDto empRequestDto) {
        Employee employee = new Employee();
        employee.setJobTitle(empRequestDto.getJobTitle());
        employee.setEmail(empRequestDto.getEmail());
        employee.setPassword(empRequestDto.getPassword());
        employee.setFirstName(empRequestDto.getFirstName());
        employee.setLastName(empRequestDto.getLastName());
        employee.setAge(empRequestDto.getAge());
        employee.setDob(empRequestDto.getDob());
        return employee;
    }

    public static EmployeeDto convertToDto(Employee employee) {
        EmployeeDto empRequestDto = new EmployeeDto();
        empRequestDto.setEmployeeId(employee.getEmployeeId());
        empRequestDto.setJobTitle(employee.getJobTitle());
        empRequestDto.setEmail(employee.getEmail());
        empRequestDto.setPassword(employee.getPassword());
        empRequestDto.setFirstName(employee.getFirstName());
        empRequestDto.setLastName(employee.getLastName());
        empRequestDto.setAge(employee.getAge());
        empRequestDto.setDob(employee.getDob());
        return empRequestDto;

    }

    public static List<EmployeeDto> convertToDtoList(List<Employee> employees) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employees.stream().forEach(p -> employeeDtoList.add(convertToDto(p)));
        return employeeDtoList;
    }


}
