package com.hrutik.example.studentprofile;

import com.hrutik.example.student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;

    private String bio;
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public StudentProfile() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public StudentProfile(String bio, Student student) {
        this.bio = bio;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
