package com.example.practice.practice.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(name="age")
    private int age;
    @Column(name="address")
    private String address;
    @Column(name = "city")
    private String city;

}
