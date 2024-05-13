package com.hrutik.example.student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    final private StudentRepository studentRepository;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok("Student Added successfully");
    }
}

