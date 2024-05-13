package com.hrutik.example.school;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @GetMapping
    public ResponseEntity<List<School>> findAll() {
        return ResponseEntity.ok(schoolRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createSchool(@RequestBody School school) {
        schoolRepository.save(school);
        return ResponseEntity.ok("School Created Successfully");
    }

}
