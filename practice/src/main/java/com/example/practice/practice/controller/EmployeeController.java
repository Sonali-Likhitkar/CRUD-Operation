package com.example.practice.practice.controller;

import com.example.practice.practice.dto.EmployeeDto;
import com.example.practice.practice.entity.Employee;
import com.example.practice.practice.service.EmployeeService;
import com.example.practice.practice.serviceimpl.EmployeeServiceImpl;
import com.example.practice.practice.util.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("employeeController")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeConverter employeeConverter;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmp(@RequestBody EmployeeDto employeeDto){
        Employee employee = EmployeeConverter.convertToEntity(employeeDto);
              Employee createEmployee=  employeeService.createEmployee(employee);
        EmployeeDto creteEmpDto = EmployeeConverter.convertToDto(createEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(creteEmpDto);
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/updateEmployeeById/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long employeeId,@RequestBody EmployeeDto employeeDto) {
        Employee employee = EmployeeConverter.convertToEntity(employeeDto);
        Optional<Employee> updateEmployee = employeeService.updateEmployee(employeeId, employee);
        if (updateEmployee.isPresent()) {
            EmployeeDto updateEmpDto = EmployeeConverter.convertToDto(updateEmployee.get());
             return ResponseEntity.status(HttpStatus.OK).body(updateEmpDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long employeeId){
      return employeeService.deleteEmployee(employeeId);

    }
//    @DeleteMapping("/deleteEmployee/{employeeId}")
//    public ResponseEntity<Void> deleteEmployeeById(@PathVariable long employeeId) {
//        employeeService.deleteEmployee(employeeId);
//        return ResponseEntity.noContent().build();
//    }

}
