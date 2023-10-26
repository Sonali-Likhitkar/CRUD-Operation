package com.example.practice.practice.serviceimpl;

import com.example.practice.practice.dto.EmployeeDto;
import com.example.practice.practice.entity.Employee;
import com.example.practice.practice.repository.EmployeeRepository;
import com.example.practice.practice.service.EmployeeService;
import com.example.practice.practice.util.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeRepository employeeRepository;


    /**
     * @param employee
     * @return
     */
    @Override
    public Employee createEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            EmployeeDto employeeDto = EmployeeConverter.convertToDto(employee.get());
            return ResponseEntity.ok(employeeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @param employeeId
     * @param employee
     * @return
     */
    @Override
    public Optional<Employee> updateEmployee(long employeeId, Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findById(employeeId);
        if (employee1.isPresent()) {
            Employee existingEmployee = employee1.get();
            existingEmployee.setJobTitle(employee.getJobTitle());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setDob(employee.getDob());
            return Optional.of(employeeRepository.save(existingEmployee));
        } else {
            return Optional.empty();
        }
    }

    /**
     * @param employeeId
     * @return
     */
    @Override
    public ResponseEntity<String> deleteEmployee(long employeeId) {
        Optional<Employee> existEmp = employeeRepository.findById(employeeId);
        if (existEmp.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return ResponseEntity.ok().body("employee deleted  Successfully");
        } else {
          return ResponseEntity.notFound().build();

        }
    }

//    @Override
//    public ResponseEntity<Void> deleteEmployee(long employeeId) {
//        employeeRepository.deleteById(employeeId);
//      return null;
//    }
}