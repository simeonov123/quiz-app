package com.quizapp.quiz.database;

import com.quizapp.quiz.core.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);



}
