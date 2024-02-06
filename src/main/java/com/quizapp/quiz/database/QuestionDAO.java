package com.quizapp.quiz.database;

import com.quizapp.quiz.core.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Question} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and more for Question entities.
 */
public interface QuestionDAO extends JpaRepository<Question, Long>, QuestionRepositoryPort {
}
