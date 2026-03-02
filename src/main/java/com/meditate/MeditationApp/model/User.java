package com.meditate.MeditationApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter email")
    @Email(message = "Please enter valid email")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Please enter password")
    @Column(nullable = false)
    private String password;

    private LocalDate birthDate;

    private String name;
}
