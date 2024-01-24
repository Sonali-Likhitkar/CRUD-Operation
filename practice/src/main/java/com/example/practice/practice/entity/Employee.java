package com.example.practice.practice.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    @Column(name="job_title")
    private String jobTitle;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date dob;




}
