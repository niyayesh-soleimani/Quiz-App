package com.example.api;

import com.example.entity.Question;
import com.example.entity.QuestionWrapper;
import com.example.entity.Response;
import com.example.service.QuizeService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("quize")
public class QuizeController {

    @Autowired
    QuizeService quizeService;

    @PostMapping("create")
    public ResponseEntity<String> createQuize(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizeService.createQuize(category,numQ,title);
    }


    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizeQuestions(@PathVariable Long id){
        return quizeService.getQuizeQustions(id);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuize(@PathVariable long id , @RequestBody List<Response> response){
        return quizeService.calculateResult(id, response);
    }

}
