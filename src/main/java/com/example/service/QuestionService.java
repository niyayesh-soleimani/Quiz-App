package com.example.service;


import com.example.entity.Question;
import com.example.repository.QuestionDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDA questionDA;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = questionDA.findAll();
            return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {

        try {
            List<Question> questions = questionDA.getQuestionByCategory(category);
            return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    public String addQuestion(Question question) {
        questionDA.save(question);
        return"success";
    }
}
