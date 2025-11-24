package com.selfstudyassistant.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class responsible for providing a reusable JDBC Connection.
 * Configuration is loaded from db.properties.
 */
public class DBConnectionUtil {

    private static final String PROPERTIES_FILE = "/db.properties";
    private static String url;
    private static String username;
    private static String password;

    static {
        try (InputStream input = DBConnectionUtil.class.getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new RuntimeException("db.properties file not found in classpath");
            }

            Properties props = new Properties();
            props.load(input);

            String driver = props.getProperty("db.driver");
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");

            Class.forName(driver); // Load JDBC driver
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize DBConnectionUtil", e);
        }
    }

    /**
     * Returns a new JDBC Connection using the configured properties.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
