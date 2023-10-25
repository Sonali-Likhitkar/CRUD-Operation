package com.example.practice.practice.service;

import com.example.practice.practice.entity.Students;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    Students save(Students students);

    List<Students> getListOfStudents();


    ResponseEntity<Students> getStudentById(Long studentId);

    ResponseEntity<String> updateStudentData(Long studentId, Students students);

    ResponseEntity<String> deleteById(Long studentId);
}
