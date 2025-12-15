package com.selfstudyassistant.model;

/**
 * Represents a quiz question used for self-assessment.
 */
public class QuizQuestion {

    private int id;
    private int subjectId;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char correctOption;
    private String difficulty; // EASY, MEDIUM, HARD

    public QuizQuestion() {}

    public QuizQuestion(int subjectId, String questionText,
                        String optionA, String optionB, String optionC, String optionD,
                        char correctOption, String difficulty) {

        this.subjectId = subjectId;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.difficulty = difficulty;
    }

    public QuizQuestion(int id, int subjectId, String questionText,
                        String optionA, String optionB, String optionC, String optionD,
                        char correctOption, String difficulty) {

        this(subjectId, questionText, optionA, optionB, optionC, optionD, correctOption, difficulty);
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

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public char getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(char correctOption) {
        this.correctOption = correctOption;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
