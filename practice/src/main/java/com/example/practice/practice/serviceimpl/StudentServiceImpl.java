package com.example.practice.practice.serviceimpl;
import com.example.practice.practice.constant.UserConstant;
import com.example.practice.practice.entity.Students;
import com.example.practice.practice.repository.StudentRepository;
import com.example.practice.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public Students save(Students students) {
        System.out.println("encryptedPassword ======> "+this.bCryptPasswordEncoder.encode(students.getPassword()));
        Students std = students.toBuilder().password(this.bCryptPasswordEncoder.encode(students.getPassword())).build();
        return studentRepository.save(std);
    }

    public List<Students> getListOfStudents() {
        return studentRepository.findAll();
    }


    /**
     * @param studentId
     * @return
     */
    @Override
    public ResponseEntity<Students> getStudentById(Long studentId) {
        try {
            Students student = studentRepository.findById(studentId).get();

            if (student != null) {
                return ResponseEntity.ok(student);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * @param studentId
     * @param students
     * @return
     */
    @Override
    public ResponseEntity<String> updateStudentData(Long studentId, Students students) {
        Students existingStd = studentRepository.findById(studentId).get();
        if (existingStd != null) {
            existingStd = Students.builder().studentId(students.getStudentId()).email(students.getEmail()).password(students.getPassword()).firstName(students.getFirstName())
                            .lastName(students.getLastName()).address (students.getAddress()).city(students.getCity())
                            .age(students.getAge()).build();
            studentRepository.save(existingStd);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found ");
        }
        return new ResponseEntity(UserConstant.DATA_UPDATED, HttpStatus.OK);
    }

    /**
     * @param studentId
     * @return
     */
    @Override
    public ResponseEntity<String> deleteById(Long studentId) {
        Students std = studentRepository.findById(studentId).get();
        if (std != null) {
            studentRepository.deleteById(studentId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Exist");
        }
         return  ResponseEntity.ok().body("User deleted successfully");
    }



}


// Students.builder().studentId(students.getStudentId()).build();
