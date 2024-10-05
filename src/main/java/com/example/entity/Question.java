package com.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "question")
@Table(name = "question")
@SequenceGenerator(name = "question_seq", sequenceName = "question_seq", allocationSize = 1)
public class Question {
    @Id
    @GeneratedValue(generator = "question_seq")
    private Long id;

    @Column(name = "QUESTION_TITLE")
    private String questionTitle;

    @Column(name = "OPTION1")
    private String option1;

    @Column(name = "OPTION2")
    private String option2;

    @Column(name = "OPTION3")
    private String option3;

    @Column(name = "OPTION4")
    private String option4;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "DIFFICULTY_LEVEL")
    private String difficultyLevel;


    @Column(name = "CATEGORY")
    private String category;

}


