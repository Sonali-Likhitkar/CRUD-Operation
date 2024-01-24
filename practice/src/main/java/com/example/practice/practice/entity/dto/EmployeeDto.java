package com.example.practice.practice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private long employeeId;
    private String jobTitle;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private Date dob;
//    private Certificate certificate;
}
