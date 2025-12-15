package com.selfstudyassistant.dao;

import com.selfstudyassistant.model.User;
import com.selfstudyassistant.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for User entity.
 * Responsible for all database operations related to users.
 */
public class UserDao {

    private static final String INSERT_SQL =
            "INSERT INTO users (name, email, password, semester) VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL_SQL =
            "SELECT id, name, email, password, semester FROM users";

    public void save(User user) {
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getSemester());

            ps.executeUpdate();

            // Set generated id back to user object
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("semester")
                );
                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching users: " + e.getMessage());
            e.printStackTrace();
        }

        return users;
    }

    public User findByEmail(String email) {
        ValidationUtil.validateEmail(email);

        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection con = DBConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("semester")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch user by email");
        }
    }

}
