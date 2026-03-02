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

    public MeditationSession() {}

    public MeditationSession(User user, int durationMinutes, boolean isTemplate) {
        this.user = user;
        this.durationMinutes = durationMinutes;
        this.isTemplate = isTemplate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    @Override
    public String toString() {
        return "MeditationSession{" +
                "id=" + id +
                ", user=" + user +
                ", durationMinutes=" + durationMinutes +
                ", isTemplate=" + isTemplate +
                '}';
    }
}
