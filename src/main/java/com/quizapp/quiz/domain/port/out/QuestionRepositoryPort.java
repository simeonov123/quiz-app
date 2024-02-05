package com.quizapp.quiz.domain.port.out;

import com.quizapp.quiz.domain.model.Question;

public interface QuestionRepositoryPort {
    Question save(Question question);
}
