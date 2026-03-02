package com.meditate.MeditationApp.repository;

import com.meditate.MeditationApp.model.MeditationSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeditationSessionRepository extends JpaRepository<MeditationSession, Long> {

    // used Optional to represent the possibility of absence and avoid NullPointerExceptions
    Optional<MeditationSession> findSessionByUserId(Long userId);
}
