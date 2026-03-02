package com.meditate.MeditationApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "meditation_sessions")
public class MeditationSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)                      //fetch user data only when needed
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @Min(value = 1, message = "Minimum duration is 1 minute")
    private int durationMinutes;

    private boolean isTemplate;                             //checks if the session is predefined or not
}
