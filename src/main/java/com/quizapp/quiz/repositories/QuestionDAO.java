package com.quizapp.quiz.repositories;

import com.quizapp.quiz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Question} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and more for Question entities.
 */
public interface QuestionDAO extends JpaRepository<Question, Long> {
}
