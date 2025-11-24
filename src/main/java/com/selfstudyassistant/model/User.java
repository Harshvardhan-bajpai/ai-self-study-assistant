package com.selfstudyassistant.model;

/**
 * Represents a student using the self-study assistant.
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private int semester;

    public User() {
        // no-arg constructor required by many frameworks and libraries
    }

    public User(String name, String email, String password, int semester) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.semester = semester;
    }

    public User(int id, String name, String email, String password, int semester) {
        this(name, email, password, semester);
        this.id = id;
    }

    // Getters and setters (encapsulation)

    public int getId() {
        return id;
    }

    public void setId(int id) {  // in real life, id is usually set by DB
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { // for now plain, later can be hashed
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", semester=" + semester +
                '}';
    }
}
