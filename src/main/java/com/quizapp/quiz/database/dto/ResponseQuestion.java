package com.quizapp.quiz.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for sending question information back to clients.
 * It includes the question's ID and the question text along with the four possible answers.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseQuestion {

    private Integer id;

    private String question;

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;
}
