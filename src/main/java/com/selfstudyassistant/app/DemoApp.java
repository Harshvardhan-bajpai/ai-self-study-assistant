package com.selfstudyassistant.app;

import com.selfstudyassistant.dao.*;
import com.selfstudyassistant.model.*;

import java.util.List;

/**
 * Simple console application to test database connectivity and DAO classes.
 */
public class DemoApp {

    public static void main(String[] args) {
        // Create DAO instances
        SubjectDao subjectDao = new SubjectDao();
        UserDao userDao = new UserDao();
        FaqDao faqDao = new FaqDao();
        QuizQuestionDao quizQuestionDao = new QuizQuestionDao();

        // 1. Insert a subject
        Subject javaSubject = new Subject("Java Programming", "JAVA101");
        subjectDao.save(javaSubject);
        System.out.println("Inserted Subject: " + javaSubject);

        // 2. Insert a user
        User user = new User("Harsh", "harsh@example.com", "password123", 3);
        userDao.save(user);
        System.out.println("Inserted User: " + user);

        // 3. Insert a FAQ
        Faq faq = new Faq(
                javaSubject.getId(),
                "inheritance,extend,is-a",
                "Inheritance allows one class to acquire properties of another class using 'extends'.",
                "EASY"
        );
        faqDao.save(faq);
        System.out.println("Inserted FAQ: " + faq);

        // 4. Insert a quiz question
        QuizQuestion question = new QuizQuestion(
                javaSubject.getId(),
                "Which keyword is used to inherit a class in Java?",
                "this", "super", "extends", "implements",
                'C',
                "EASY"
        );
        quizQuestionDao.save(question);
        System.out.println("Inserted QuizQuestion: " + question);

        // 5. Fetch all users
        List<User> allUsers = userDao.findAll();
        System.out.println("\nAll Users:");
        allUsers.forEach(System.out::println);

        // 6. Fetch all subjects
        List<Subject> allSubjects = subjectDao.findAll();
        System.out.println("\nAll Subjects:");
        allSubjects.forEach(System.out::println);
    }
}
