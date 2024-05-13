package com.hrutik.example.school;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    final private SchoolRepository schoolRepository;
    final private SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public ResponseEntity<List<SchoolDto>> findAllSchools() {
        return ResponseEntity.ok(schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<SchoolDto> createSchool(
             SchoolDto schoolDto
    ) {
        var school = schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return ResponseEntity.ok(schoolDto);
    }
}
