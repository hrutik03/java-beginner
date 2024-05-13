package com.hrutik.example.student;

import com.hrutik.example.school.School;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> findAll() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> getStudent(
            @PathVariable Integer studentId
    ) {
        return studentService.getStudent(studentId);
    }
}

