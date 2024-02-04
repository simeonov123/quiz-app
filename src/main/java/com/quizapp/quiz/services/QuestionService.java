package com.quizapp.quiz.services;

import com.quizapp.quiz.DTOs.RequestQuestionDTO;
import com.quizapp.quiz.DTOs.ResponseQuestionDTO;
import com.quizapp.quiz.entities.Question;
import com.quizapp.quiz.repositories.QuestionDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for handling question operations.
 * This class is responsible for business logic related to quiz questions, including creating new questions.
 */
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionDAO questionDAO;

    /**
     * Creates a new question in the database based on the provided DTO.
     * Validates that all required fields in the {@link RequestQuestionDTO} are present and not blank.
     *
     * @param requestQuestionDTO DTO containing question data to be saved.
     * @return {@link ResponseQuestionDTO} containing the saved question data.
     * @throws RuntimeException if any of the required fields are null or blank.
     */

    public ResponseQuestionDTO createQuestion(RequestQuestionDTO requestQuestionDTO) {
        // Validate required fields are present
        if ((requestQuestionDTO.getCorrectAnswer() == null || requestQuestionDTO.getCorrectAnswer().isBlank()) ||
                (requestQuestionDTO.getQuestion() == null || requestQuestionDTO.getQuestion().isBlank()) ||
                (requestQuestionDTO.getAnswerA() == null || requestQuestionDTO.getAnswerA().isBlank()) ||
                (requestQuestionDTO.getAnswerB() == null || requestQuestionDTO.getAnswerB().isBlank()) ||
                (requestQuestionDTO.getAnswerC() == null || requestQuestionDTO.getAnswerC().isBlank()) ||
                (requestQuestionDTO.getAnswerD() == null || requestQuestionDTO.getAnswerD().isBlank())) {
            throw new RuntimeException("All fields must be present.");
        }

        // Map DTO to entity and save
        Question question = new Question(requestQuestionDTO.getQuestion(), requestQuestionDTO.getAnswerA(), requestQuestionDTO.getAnswerB(), requestQuestionDTO.getAnswerC(), requestQuestionDTO.getAnswerD(), requestQuestionDTO.getCorrectAnswer());

        // Save Question to the database
        Question savedQuestion = questionDAO.save(question);


        // Map saved entity to response DTO
        return new ResponseQuestionDTO(savedQuestion.getId(), savedQuestion.getQuestion(), savedQuestion.getAnswerA(), savedQuestion.getAnswerB(), savedQuestion.getAnswerC(), savedQuestion.getAnswerD());
    }
}
