package com.selfstudyassistant.dao;

import com.selfstudyassistant.model.QuizQuestion;
import com.selfstudyassistant.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for QuizQuestion entity.
 */
public class QuizQuestionDao {

    private static final String INSERT_SQL =
            "INSERT INTO quiz_questions (subject_id, question_text, " +
            "option_a, option_b, option_c, option_d, correct_option, difficulty) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_SQL =
            "SELECT id, subject_id, question_text, option_a, option_b, option_c, option_d, " +
            "correct_option, difficulty FROM quiz_questions";

    public void save(QuizQuestion question) {
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, question.getSubjectId());
            ps.setString(2, question.getQuestionText());
            ps.setString(3, question.getOptionA());
            ps.setString(4, question.getOptionB());
            ps.setString(5, question.getOptionC());
            ps.setString(6, question.getOptionD());
            ps.setString(7, String.valueOf(question.getCorrectOption()));
            ps.setString(8, question.getDifficulty());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    question.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error saving quiz question: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<QuizQuestion> findAll() {
        List<QuizQuestion> questions = new ArrayList<>();

        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                QuizQuestion question = new QuizQuestion(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("question_text"),
                        rs.getString("option_a"),
                        rs.getString("option_b"),
                        rs.getString("option_c"),
                        rs.getString("option_d"),
                        rs.getString("correct_option").charAt(0),
                        rs.getString("difficulty")
                );
                questions.add(question);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching quiz questions: " + e.getMessage());
            e.printStackTrace();
        }

        return questions;
    }
    public List<QuizQuestion> findByDifficulty(String difficulty) {
        ValidationUtil.validateDifficulty(difficulty);
        List<QuizQuestion> questions = new ArrayList<>();

        String sql = "SELECT * FROM quiz_questions WHERE difficulty = ?";
        try (Connection con = DBConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, difficulty);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                questions.add(new QuizQuestion(
                    rs.getInt("id"),
                    rs.getInt("subject_id"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_option").charAt(0),
                    rs.getString("difficulty")
                ));
            }
            return questions;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch quiz questions");
        }
    }

}
