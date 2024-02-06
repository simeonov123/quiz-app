package com.quizapp.quiz.database.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

/**
 * Data Transfer Object for creating a new question.
 * It contains the question, four possible answers, and the correct answer,
 * with validation constraints to ensure none are empty or null.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestQuestion {

    @NotEmpty(message = "Question can't be empty")
    private String question;

    @NotEmpty(message = "Answer A can't be empty")
    private String answerA;

    @NotEmpty(message = "Answer B can't be empty")
    private String answerB;

    @NotEmpty(message = "Answer C can't be empty")
    private String answerC;

    @NotEmpty(message = "Answer D can't be empty")
    private String answerD;

    @NotEmpty(message = "The correct answer can't be empty")
    private String correctAnswer;
}
