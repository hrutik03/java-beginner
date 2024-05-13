package com.hrutik.example.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "Firstname should not be empty")
        String firstname,

        @NotEmpty(message = "LastName should not be empty")
        String lastname,

        @NotEmpty
        @Email
        String email,

        Integer schoolId
) {}
