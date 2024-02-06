package com.quizapp.quiz;

import com.quizapp.quiz.database.dto.RequestQuestion;
import com.quizapp.quiz.database.dto.ResponseQuestion;
import com.quizapp.quiz.core.service.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuestionTests {

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    @Test
    void createQuestionThenReturn200() {
        RequestQuestion requestQuestion = new RequestQuestion("What's Obama's last name?", "Donald", "Elon", "Barak", "Obama", "Obama");

        ResponseQuestion responseQuestion = questionServiceImpl.createQuestion(requestQuestion);


        assertAll("Response Question DTO validations",
                () -> assertEquals(responseQuestion.getQuestion(), "What's Obama's last name?", "Question mismatch"),
                () -> assertEquals(responseQuestion.getAnswerA(), "Donald", "Answer A mismatch"),
                () -> assertEquals(responseQuestion.getAnswerB(), "Elon", "Answer B mismatch"),
                () -> assertEquals(responseQuestion.getAnswerC(), "Barak", "Answer C mismatch"),
                () -> assertEquals(responseQuestion.getAnswerD(), "Obama", "Answer D mismatch")

        );
    }

}
