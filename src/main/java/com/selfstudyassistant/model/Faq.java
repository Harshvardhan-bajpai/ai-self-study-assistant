package com.selfstudyassistant.model;

/**
 * Represents a FAQ entry used by the chatbot to answer common questions.
 */
public class Faq {

    private int id;
    private int subjectId;
    private String questionKeywords;
    private String answerText;
    private String difficulty; // EASY, MEDIUM, HARD

    public Faq() {}

    public Faq(int subjectId, String questionKeywords, String answerText, String difficulty) {
        this.subjectId = subjectId;
        this.questionKeywords = questionKeywords;
        this.answerText = answerText;
        this.difficulty = difficulty;
    }

    public Faq(int id, int subjectId, String questionKeywords, String answerText, String difficulty) {
        this(subjectId, questionKeywords, answerText, difficulty);
        this.id = id;
    }

    // Getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) { 
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getQuestionKeywords() {
        return questionKeywords;
    }

    public void setQuestionKeywords(String questionKeywords) {
        this.questionKeywords = questionKeywords;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", questionKeywords='" + questionKeywords + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
