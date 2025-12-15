package com.selfstudyassistant.model;

/**
 * Represents an academic subject (e.g., Java, DBMS, CN).
 */
public class Subject {

    private int id;
    private String name;
    private String code;

    public Subject() {}

    public Subject(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Subject(int id, String name, String code) {
        this(name, code);
        this.id = id;
    }

    // Getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) { 
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
