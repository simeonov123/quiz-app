package com.quizapp.quiz.database;

import com.quizapp.quiz.core.model.Question;

public interface QuestionRepositoryPort {
    Question save(Question question);
}
