package com.example.UserAuthentication.Entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class User {

    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Past
    private LocalDate age;
    @NotBlank
    private Gender gender;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String Password;

}
