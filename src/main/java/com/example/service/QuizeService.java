package com.example.service;

import com.example.entity.Question;
import com.example.entity.QuestionWrapper;
import com.example.entity.Quize;
import com.example.entity.Response;
import com.example.repository.QuestionDA;
import com.example.repository.QuizeDA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuizeService {

    @Autowired
    QuizeDA quizeDA ;
    @Autowired
    QuestionDA questionDA;


    @Transactional
    public ResponseEntity<Integer> calculateResult(Long id, List<Response> response) {
        Optional<Quize> quizeOptional = quizeDA.findById(id);
        if (!quizeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Quize quize = quizeOptional.get();

        List<Question> questions = quize.getQuestions();

        int right = 0;
        int i = 0;
        for (Response response1 : response) {
            if (i < questions.size() && Objects.equals(response1.getResponse(), questions.get(i).getAnswer())) {
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }



    public ResponseEntity<String> createQuize(String category, int numQ, String title) {
        List<Question> questions = questionDA.findRandomQuestionByCategory(category,numQ);
        Quize quize = new Quize();
        quize.setTitle(title);
        quize.setQuestions(questions);
        quizeDA.save(quize);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    @Transactional
    public ResponseEntity<List<QuestionWrapper>> getQuizeQustions(Long id) {
        Optional<Quize> quize = quizeDA.findById(id);
        if (quize.isPresent()) {
            List<Question> questionsFromDB = quize.get().getQuestions(); // بارگذاری سوالات
            List<QuestionWrapper> questionForUsers = new ArrayList<>();
            for (Question q : questionsFromDB) {
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(),
                        q.getOption2(), q.getOption3(), q.getOption4());
                questionForUsers.add(qw);
            }
            return new ResponseEntity<>(questionForUsers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
