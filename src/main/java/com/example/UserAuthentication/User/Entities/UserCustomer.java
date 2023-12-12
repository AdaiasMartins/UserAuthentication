package com.example.UserAuthentication.User.Entities;

import com.example.UserAuthentication.User.DTO.RegisterDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCustomer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Past
    private LocalDate age;
    @Enumerated
    private Gender gender;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String Password;

    public UserCustomer(RegisterDTO data) {
        this.name = data.name();
        this.age = data.age();
        this.gender = data.gender();
        this.email = data.email();
        this.Password = data.password();
    }
}
