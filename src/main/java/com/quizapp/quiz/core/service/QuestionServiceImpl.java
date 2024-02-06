package com.quizapp.quiz.core.service;

import com.quizapp.quiz.database.dto.RequestQuestion;
import com.quizapp.quiz.database.dto.ResponseQuestion;
import com.quizapp.quiz.core.assembler.ResponseAssembler;
import com.quizapp.quiz.core.model.Question;
import com.quizapp.quiz.database.QuestionRepositoryPort;
import com.quizapp.quiz.security.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for handling question operations.
 * This class is responsible for business logic related to quiz questions, including creating new questions.
 */
@Service
public class QuestionServiceImpl extends ResponseAssembler implements QuestionService {

    private final QuestionRepositoryPort questionRepositoryPort;

    public QuestionServiceImpl(AuthenticationService authenticationService, QuestionRepositoryPort questionRepositoryPort) {
        super(authenticationService);
        this.questionRepositoryPort = questionRepositoryPort;
    }


    /**
     * Creates a new question in the database based on the provided DTO.
     * Validates that all required fields in the {@link RequestQuestion} are present and not blank.
     *
     * @param requestQuestion DTO containing question data to be saved.
     * @return {@link ResponseQuestion} containing the saved question data.
     * @throws RuntimeException if any of the required fields are null or blank.
     */

    public ResponseQuestion createQuestion(RequestQuestion requestQuestion) {
        // Validate required fields are present
        if (!fieldsAreValid(requestQuestion)) {
            // TODO: to be replaced with a custom exception later on or remove validation in case we decide this will be handled only from the client's side
            throw new RuntimeException("All fields must be present.");
        }



        // Map DTO to entity
        Question question = assemblerQuestion(requestQuestion);

        // Save Question to the database
        Question savedQuestion = questionRepositoryPort.save(question);


        // Map saved entity to response DTO and return
        return assembleResponse(savedQuestion);
    }
}
