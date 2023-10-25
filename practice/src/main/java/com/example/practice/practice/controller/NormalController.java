package com.example.practice.practice.controller;

import com.example.practice.practice.entity.Employee;
import org.hibernate.Session;

public class NormalController {

    public void name(){
        Employee employee = new Employee();
        employee.setEmployeeId(1);
        employee.setFirstName("Sona");
        employee.setLastName("Likhitkar");
        employee.setAge(22);
        employee.setJobTitle("software developer");
        employee.setPassword("sonali@123");


    }

}
