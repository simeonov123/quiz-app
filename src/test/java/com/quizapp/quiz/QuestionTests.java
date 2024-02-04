package com.quizapp.quiz;

import com.quizapp.quiz.DTOs.RequestQuestionDTO;
import com.quizapp.quiz.DTOs.ResponseQuestionDTO;
import com.quizapp.quiz.services.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuestionTests {

    @Autowired
    private QuestionService questionService;

    @Test
    void createQuestionThenReturn200() {
        RequestQuestionDTO requestQuestionDTO = new RequestQuestionDTO("What's Obama's last name?", "Donald", "Elon", "Barak", "Obama", "Obama");

        ResponseQuestionDTO responseQuestionDTO = questionService.createQuestion(requestQuestionDTO);


        assertAll("Response Question DTO validations",
                () -> assertEquals(responseQuestionDTO.getQuestion(), "What's Obama's last name?", "Question mismatch"),
                () -> assertEquals(responseQuestionDTO.getAnswerA(), "Donald", "Answer A mismatch"),
                () -> assertEquals(responseQuestionDTO.getAnswerB(), "Elon", "Answer B mismatch"),
                () -> assertEquals(responseQuestionDTO.getAnswerC(), "Barak", "Answer C mismatch"),
                () -> assertEquals(responseQuestionDTO.getAnswerD(), "Obama", "Answer D mismatch")

        );
    }

}
