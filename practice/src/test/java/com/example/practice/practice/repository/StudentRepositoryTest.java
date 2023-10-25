package com.example.practice.practice.repository;

import com.example.practice.practice.entity.Students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {


    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findByEmail() {
        Students student = new Students(123,"sonali.likhitkar@gmail.com","Sonali","Likhitkar",23,"pragti nagar","Bhopal");
        studentRepository.save(student);

    }
}