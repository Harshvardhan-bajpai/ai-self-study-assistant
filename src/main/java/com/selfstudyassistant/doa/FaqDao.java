package com.selfstudyassistant.dao;

import com.selfstudyassistant.model.Faq;
import com.selfstudyassistant.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for Faq entity.
 */
public class FaqDao {

    private static final String INSERT_SQL =
            "INSERT INTO faq (subject_id, question_keywords, answer_text, difficulty) " +
            "VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL_SQL =
            "SELECT id, subject_id, question_keywords, answer_text, difficulty FROM faq";

    public void save(Faq faq) {
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, faq.getSubjectId());
            ps.setString(2, faq.getQuestionKeywords());
            ps.setString(3, faq.getAnswerText());
            ps.setString(4, faq.getDifficulty());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    faq.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error saving FAQ: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Faq> findAll() {
        List<Faq> faqs = new ArrayList<>();

        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Faq faq = new Faq(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("question_keywords"),
                        rs.getString("answer_text"),
                        rs.getString("difficulty")
                );
                faqs.add(faq);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching FAQs: " + e.getMessage());
            e.printStackTrace();
        }

        return faqs;
    }
}
