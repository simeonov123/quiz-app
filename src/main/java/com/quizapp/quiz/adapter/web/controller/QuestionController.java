package com.quizapp.quiz.adapter.web.controller;

import com.quizapp.quiz.adapter.web.dto.RequestQuestionDTO;
import com.quizapp.quiz.adapter.web.dto.ResponseQuestionDTO;
import com.quizapp.quiz.application.impl.QuestionServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionServiceImpl questionServiceImpl;

    public QuestionController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @PostMapping("/create-question")
    public ResponseEntity<ResponseQuestionDTO> createContact(
            @Valid @RequestBody RequestQuestionDTO requestQuestionDTO) {
        return ResponseEntity.ok(questionServiceImpl.createQuestion(requestQuestionDTO));
    }
}
