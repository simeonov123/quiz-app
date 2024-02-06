package com.quizapp.quiz.core.service;

import com.quizapp.quiz.database.dto.RequestQuestion;
import com.quizapp.quiz.database.dto.ResponseQuestion;

public interface QuestionService {
    ResponseQuestion createQuestion(RequestQuestion requestQuestion);
}
