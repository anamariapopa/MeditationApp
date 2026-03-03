package com.meditate.MeditationApp.service;

import com.meditate.MeditationApp.model.User;
import com.meditate.MeditationApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Registers a new user if the email is not already taken.
     * * @param user The user entity to be saved.
     * @return The saved user with an assigned ID.
     * @throws RuntimeException if the email is already registered.
     */
    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists. Email unavailable");
        }
        else return userRepository.save(user);
    }

    /**
     * Deletes a user by their ID.
     * @param userId
     */
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        }
        else throw new RuntimeException("User not found");
    }


    /**
     * Updates the profile information of an existing user.
     *
     * @param userId         The unique ID of the user to be updated.
     * @param newUserDetails Object containing the new data (name, birthDate).
     * @return The updated User entity.
     * @throws RuntimeException if no user is found with the provided ID.
     */
    public User updateUser(Long userId, User newUserDetails) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        existingUser.setName(newUserDetails.getName());
        existingUser.setBirthDate(newUserDetails.getBirthDate());

        return userRepository.save(existingUser);
    }


    /**
     * User authentication.
     * Checks if the email and password are correct.
     *
     * @param email    Email address of the user.
     * @param password Password of the user.
     * @return User object if authentication is successful.
     * @throws RuntimeException if the email was not found or the password is incorrect.
     */
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }
}
