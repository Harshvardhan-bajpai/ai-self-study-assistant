package com.selfstudyassistant.app;

import com.selfstudyassistant.dao.*;
import com.selfstudyassistant.model.*;

import java.util.List;

/**
 * Simple console application to test database connectivity and DAO classes.
 */
public class DemoApp {

    public static void main(String[] args) {

        SubjectDao subjectDao = new SubjectDao();
        UserDao userDao = new UserDao();
        FaqDao faqDao = new FaqDao();
        QuizQuestionDao quizDao = new QuizQuestionDao();
        FaqMatcherService matcher = new FaqMatcherService();

        Subject subject = subjectDao.findByCode("JAVA101");
        if (subject == null) {
            subject = new Subject("Java Programming", "JAVA101");
            subjectDao.save(subject);
        }

        User user = userDao.findByEmail("harsh@example.com");
        if (user == null) {
            user = new User("Harsh", "harsh@example.com", "root", 3);
            userDao.save(user);
        }

        List<Faq> faqs = faqDao.findBySubjectId(subject.getId());
        if (faqs.isEmpty()) {
            faqDao.save(new Faq(subject.getId(),
                    "inheritance extends is-a",
                    "Inheritance allows one class to acquire another class properties.",
                    "EASY"));
            faqs = faqDao.findBySubjectId(subject.getId());
        }

        Faq answer = matcher.findBestMatch("explain inheritance in java", faqs);
        System.out.println("AI Assistant Answer:");
        System.out.println(answer.getAnswerText());

        System.out.println("Easy Quiz Questions:");
        quizDao.findByDifficulty("EASY").forEach(q ->
                System.out.println(q.getQuestionText()));
    }
}
