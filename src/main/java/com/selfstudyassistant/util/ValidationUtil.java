package com.selfstudyassistant.util;

public class ValidationUtil {

    public static void validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
    }

    public static void validateDifficulty(String difficulty) {
        if (!difficulty.matches("EASY|MEDIUM|HARD")) {
            throw new IllegalArgumentException("Invalid difficulty level");
        }
    }
}
