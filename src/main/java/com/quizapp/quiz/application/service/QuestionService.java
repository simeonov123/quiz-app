package com.quizapp.quiz.application.service;

import com.quizapp.quiz.adapter.web.dto.RequestQuestionDTO;
import com.quizapp.quiz.adapter.web.dto.ResponseQuestionDTO;

public interface QuestionService {
    ResponseQuestionDTO createQuestion(RequestQuestionDTO requestQuestionDTO);
}
