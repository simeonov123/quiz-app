package com.quizapp.quiz.controllers;

import com.quizapp.quiz.DTOs.RequestQuestionDTO;
import com.quizapp.quiz.DTOs.ResponseQuestionDTO;
import com.quizapp.quiz.services.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create-question")
    public ResponseEntity<ResponseQuestionDTO> createContact(
            @Valid @RequestBody RequestQuestionDTO requestQuestionDTO) {
        return ResponseEntity.ok(questionService.createQuestion(requestQuestionDTO));
    }
}
