package com.selfstudyassistant.dao;

import com.selfstudyassistant.model.Subject;
import com.selfstudyassistant.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for Subject entity.
 */
public class SubjectDao {

    private static final String INSERT_SQL =
            "INSERT INTO subjects (name, code) VALUES (?, ?)";

    private static final String SELECT_ALL_SQL =
            "SELECT id, name, code FROM subjects";

    public void save(Subject subject) {
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, subject.getName());
            ps.setString(2, subject.getCode());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    subject.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error saving subject: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Subject> findAll() {
        List<Subject> subjects = new ArrayList<>();

        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Subject subject = new Subject(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("code")
                );
                subjects.add(subject);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching subjects: " + e.getMessage());
            e.printStackTrace();
        }

        return subjects;
    }

    public Subject findByCode(String code) {
        ValidationUtil.validateNotEmpty(code, "Subject Code");

        String sql = "SELECT * FROM subjects WHERE code = ?";
        try (Connection con = DBConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Subject(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("code")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch subject");
        }
    }

}
