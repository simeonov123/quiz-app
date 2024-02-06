package com.quizapp.quiz.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quizapp.quiz.core.model.TokenType;
import com.quizapp.quiz.core.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private boolean expired;
    private boolean revoked;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", tokenType=" + tokenType +
                ", expired=" + expired +
                ", revoked=" + revoked +
                '}';
    }
}