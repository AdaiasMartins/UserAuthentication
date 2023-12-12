package com.example.UserAuthentication.User.DTO;

import com.example.UserAuthentication.User.Entities.Gender;

import java.time.LocalDate;

public record RegisterDTO(
        String name,
        LocalDate age,
        Gender gender,
        String email,
        String password
) {
}
