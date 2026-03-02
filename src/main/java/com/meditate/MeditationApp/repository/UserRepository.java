package com.meditate.MeditationApp.repository;

import com.meditate.MeditationApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // used Optional to represent the possibility of absence and avoid NullPointerExceptions
    Optional<User> findByEmail(String email);

}
