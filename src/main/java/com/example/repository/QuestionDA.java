package com.example.repository;
import com.example.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDA extends JpaRepository<Question, Long> {


    List<Question>getQuestionByCategory(String category);




    @Query(value = "SELECT * FROM (SELECT * FROM Question q WHERE q.category = :category ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <= :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);


}
