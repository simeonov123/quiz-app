package com.quizapp.quiz.web.controller;

import com.quizapp.quiz.database.dto.RequestQuestion;
import com.quizapp.quiz.database.dto.ResponseQuestion;
import com.quizapp.quiz.core.service.QuestionServiceImpl;
import com.quizapp.quiz.core.service.QuestionService;
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

    public QuestionController(QuestionServiceImpl questionServiceImpl) {
        this.questionService = questionServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseQuestion> createContact(
            @Valid @RequestBody RequestQuestion requestQuestion) {
        return ResponseEntity.ok(questionService.createQuestion(requestQuestion));
    }
}
