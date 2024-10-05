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




public class QuestionWrapper {

    @Id
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


}
