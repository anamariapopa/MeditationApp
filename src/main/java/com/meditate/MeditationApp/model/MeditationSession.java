package com.meditate.MeditationApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Table(name = "meditation_sessions")
@Data
public class MeditationSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)                      //fetch user data only when needed
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})          //ignores Hibernate lazy loading
    private User user;

    @Column(nullable = false)
    @Min(value = 1, message = "Minimum duration is 1 minute")
    private int durationMinutes;

    private boolean isTemplate;                             //checks if the session is predefined or not

    public MeditationSession() {}

    public MeditationSession(User user, int durationMinutes, boolean isTemplate) {
        this.user = user;
        this.durationMinutes = durationMinutes;
        this.isTemplate = isTemplate;
    }
}
