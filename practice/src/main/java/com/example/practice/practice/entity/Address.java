package com.example.practice.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name="employee_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @Column(length = 50,name="street")
    private String Street;
    @Column(length = 80,name="city")
    private String city;
    @Column(name="is_open")
    private  boolean isOpen;
    @Transient
    private  int x;

}
