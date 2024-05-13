package com.hrutik.example.student;

import com.hrutik.example.school.School;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<StudentResponseDto> createStudent(
            @Valid @RequestBody StudentDto studentDto
    ) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> getStudent(
            @PathVariable Integer studentId
    ) {
        return studentService.getStudent(studentId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
