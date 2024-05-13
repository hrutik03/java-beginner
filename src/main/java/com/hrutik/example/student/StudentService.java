package com.hrutik.example.student;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    final private StudentRepository studentRepository;
    final private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public ResponseEntity<StudentResponseDto> saveStudent (StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = studentMapper.toStudentResponseDto(student);
        return ResponseEntity.ok(savedStudent);
    }

    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList())
        );
    }

    public ResponseEntity<StudentResponseDto> getStudent(Integer studentId) {
        return ResponseEntity.ok(
                studentRepository.findById(studentId)
                        .map(studentMapper::toStudentResponseDto)
                        .orElse(null)
        );
    }
}
