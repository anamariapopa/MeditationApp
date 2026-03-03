package com.meditate.MeditationApp.controller;

import com.meditate.MeditationApp.model.MeditationSession;
import com.meditate.MeditationApp.service.MeditationSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class MeditationSessionController {
    private final MeditationSessionService sessionService;

    public MeditationSessionController(MeditationSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/templates")
    public ResponseEntity<List<MeditationSession>> getTemplates() {
        return ResponseEntity.ok(sessionService.getTemplateSessions());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MeditationSession>> getUserSessions(@PathVariable Long userId) {
        return ResponseEntity.ok(sessionService.findSessionByUserId(userId));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<MeditationSession> createCustomSession(@PathVariable Long userId, @RequestBody MeditationSession session) {
        return ResponseEntity.ok(sessionService.createCustomSession(userId, session));
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<String> deleteSession(@PathVariable Long sessionId) {
        sessionService.deleteSession(sessionId);
        return ResponseEntity.ok("Session deleted successfully.");
    }
}
