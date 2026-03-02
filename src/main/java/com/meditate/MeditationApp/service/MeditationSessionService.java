package com.meditate.MeditationApp.service;

import com.meditate.MeditationApp.model.MeditationSession;
import com.meditate.MeditationApp.model.User;
import com.meditate.MeditationApp.repository.MeditationSessionRepository;
import com.meditate.MeditationApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeditationSessionService {

    private final MeditationSessionRepository sessionRepository;
    private final UserRepository userRepository;

    public MeditationSessionService(MeditationSessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    List<MeditationSession> findSessionByUserId(Long userId) {
        List<MeditationSession> sessions = sessionRepository.findSessionByUserId(userId);

        if (sessions.isEmpty()) {
            throw new RuntimeException("No sessions found for user with id: " + userId);
        }

        return sessions;
    }

    public List<MeditationSession> getTemplateSessions() {
        List<MeditationSession> templates = sessionRepository.findByIsTemplateTrue();

        if (templates.isEmpty()) {
            throw new RuntimeException("No library sessions available yet.");
        }

        return templates;
    }

    /**
     * Creates a personalized meditation session for a specific user.
     * @param userId  The ID of the user creating the session.
     * @param session The session details (duration, background sound, title).
     * @return The saved MeditationSession.
     */
    public MeditationSession createCustomSession(Long userId, MeditationSession session) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        session.setUser(user);
        session.setTemplate(false);

        return sessionRepository.save(session);
    }

    /**
     * Deletes a meditation session by its ID.
     * @param sessionId The ID of the session to be deleted.
     * @throws RuntimeException if the session is a template or not found.
     */
    void deleteSession(Long sessionId) {
        MeditationSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + sessionId));

        if (session.isTemplate())
            throw new RuntimeException("Cannot delete a template session");

        sessionRepository.deleteById(sessionId);
    }
}
