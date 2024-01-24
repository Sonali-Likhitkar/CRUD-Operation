package com.example.practice.practice.controller;

import com.example.practice.practice.constant.UserConstant;
import com.example.practice.practice.entity.Students;
import com.example.practice.practice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentController")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getHello")
    public String hello() {
        return "say hello";
    }

    @PostMapping("/saveStudent")
    public String saveStudentData(@RequestBody Students students) {
        studentService.save(students);
        return UserConstant.STUDENT_SAVE;
    }

    @GetMapping("/getAllStudents")
    public List<Students> getListOfStudents() {
        return studentService.getListOfStudents();
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable Long studentId, @RequestBody Students students) {
        return studentService.updateStudentData(studentId, students);
    }

    @GetMapping("/getById/{studentId}")
    public ResponseEntity<Students> getById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("/deleteById/{studentId}")
    public ResponseEntity<String> deleteById(@PathVariable Long studentId) {
        return studentService.deleteById(studentId);
    }
}
