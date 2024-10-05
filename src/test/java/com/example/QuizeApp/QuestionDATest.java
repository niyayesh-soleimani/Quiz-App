package com.example.QuizeApp;

import com.example.entity.Question;
import com.example.repository.QuestionDA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class QuestionDATest {

    @Autowired
    private QuestionDA questionDA; // تزریق QuestionDA

    @Test
    @Rollback(false) // رکوردها پس از تست در دیتابیس باقی می‌مانند
    public void testSaveAndFindQuestion() {
        // 1. ایجاد یک شی Question
        Question question = Question.builder()
                .questionTitle("What is the capital of France?") // عنوان سوال
                .option1("Paris") // گزینه ۱
                .option2("London") // گزینه ۲
                .option3("Berlin") // گزینه ۳
                .option4("Madrid") // گزینه ۴
                .answer("Paris") // پاسخ صحیح
                .difficultyLevel("Medium") // سطح دشواری
                .build(); // ساخت شی

        // 2. ذخیره کردن شی در دیتابیس
        questionDA.save(question);

        // 3. جستجوی شی در دیتابیس
        Optional<Question> foundQuestion = questionDA.findById(question.getId());

        // 4. بررسی وجود سوال در دیتابیس
        assertTrue(foundQuestion.isPresent(), "Question should be found");
        assertEquals("What is the capital of France?", foundQuestion.get().getQuestionTitle());
    }
}
