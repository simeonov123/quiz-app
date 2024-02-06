package com.quizapp.quiz.core.assembler;

import com.quizapp.quiz.core.model.User;
import com.quizapp.quiz.database.dto.RequestQuestion;
import com.quizapp.quiz.database.dto.ResponseQuestion;
import com.quizapp.quiz.core.model.Question;
import com.quizapp.quiz.security.auth.AuthenticationService;


public class ResponseAssembler {

    private final AuthenticationService authenticationService;

    public ResponseAssembler(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Question assemblerQuestion(RequestQuestion requestQuestion) {

        User currentUser = authenticationService.getCurrentlyLoggedUser();


        return Question.builder()
                .question(requestQuestion.getQuestion())
                .answerA(requestQuestion.getAnswerA())
                .answerB(requestQuestion.getAnswerB())
                .answerC(requestQuestion.getAnswerD())
                .answerD(requestQuestion.getAnswerC())
                .correctAnswer(requestQuestion.getCorrectAnswer())
                .user(currentUser)
                .build();
    }

    public boolean fieldsAreValid(RequestQuestion requestQuestion) {
        return !((requestQuestion.getCorrectAnswer() == null || requestQuestion.getCorrectAnswer().isBlank()) ||
                (requestQuestion.getQuestion() == null || requestQuestion.getQuestion().isBlank()) ||
                (requestQuestion.getAnswerA() == null || requestQuestion.getAnswerA().isBlank()) ||
                (requestQuestion.getAnswerB() == null || requestQuestion.getAnswerB().isBlank()) ||
                (requestQuestion.getAnswerC() == null || requestQuestion.getAnswerC().isBlank()) ||
                (requestQuestion.getAnswerD() == null || requestQuestion.getAnswerD().isBlank()));
    }

    public ResponseQuestion assembleResponse(Question question) {

        return ResponseQuestion.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answerA(question.getAnswerA())
                .answerB(question.getAnswerB())
                .answerC(question.getAnswerD())
                .answerD(question.getAnswerC())
                .build();
    }
}
