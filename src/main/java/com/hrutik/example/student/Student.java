package com.hrutik.example.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrutik.example.school.School;
import com.hrutik.example.studentprofile.StudentProfile;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;

    private String name;
    private String lastName;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    @Column(unique = true)
    private String email;

    public Student(String name, String lastName, String email, School school, StudentProfile studentProfile) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.school = school;
        this.studentProfile = studentProfile;
    }

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    public Integer getId() {
        return id;
    }

    public Student() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
