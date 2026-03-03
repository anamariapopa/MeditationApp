package com.meditate.MeditationApp.controller;

import com.meditate.MeditationApp.model.User;
import com.meditate.MeditationApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")                       // /api/ prefix distinguishes Backend API routes from Frontend/Web resources
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Registers a new user.
     * @RequestBody transforms the received JSON data into a User object.
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.registerUser(user);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * Logs in a user.
     * @param user
     */
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User loggedUser = userService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(loggedUser);
    }

    /**
     * Deletes a user by their ID.
     * @PathVariable extracts the ID from the URL.
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    /**
     * Updates the profile information of an existing user.
     * @param id
     * @param userDetails
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

}
