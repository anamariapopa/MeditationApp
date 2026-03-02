package com.meditate.MeditationApp.repository;

import com.meditate.MeditationApp.model.MeditationSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeditationSessionRepository extends JpaRepository<MeditationSession, Long> {

    List<MeditationSession> findSessionByUserId(Long userId);

    List<MeditationSession> findByIsTemplateTrue();
}
