package com.hrutik.example.school;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    final private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity<List<SchoolDto>> findAll() {
        return schoolService.findAllSchools();
    }

    @PostMapping
    public ResponseEntity<SchoolDto> createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.createSchool(schoolDto);
    }
}
