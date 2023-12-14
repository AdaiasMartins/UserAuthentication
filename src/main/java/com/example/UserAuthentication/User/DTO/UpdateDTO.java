package com.example.UserAuthentication.User.DTO;

import com.example.UserAuthentication.User.Entities.Gender;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UpdateDTO(
        @NotBlank
        Long id,

        String name,

        Gender gender,

        LocalDate age,

        String email,

        String password
) {
}
