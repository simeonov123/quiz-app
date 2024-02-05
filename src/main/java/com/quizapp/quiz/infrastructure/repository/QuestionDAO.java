package com.quizapp.quiz.infrastructure.repository;

import com.quizapp.quiz.domain.model.Question;
import com.quizapp.quiz.domain.port.out.QuestionRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Question} entity.
 * Extends {@link JpaRepository} to provide CRUD operations and more for Question entities.
 */
public interface QuestionDAO extends JpaRepository<Question, Long>, QuestionRepositoryPort {
}
