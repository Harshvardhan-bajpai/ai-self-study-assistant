# AI-Powered Self-Study Assistant

A Java + MySQL backend for a self-study assistant that helps students manage subjects, FAQs, and quiz questions.  
This repo contains the core backend foundation: domain models, database schema, JDBC setup, and DAO layer.

> The goal of this phase is to build a solid, clean backend that can later be connected to a web UI and a simple “AI-style” assistant.

---

## 1. Overview

The AI-Powered Self-Study Assistant is designed to support students in self-study by:

- Storing student accounts
- Managing subjects (e.g., Java, DBMS, CN)
- Storing FAQ-style concept explanations
- Storing quiz questions for self-assessment

Right now this project is focused on:

- Core Java & OOP
- JDBC connectivity
- MySQL database schema
- Clean project structure and separation of concerns

A small console app (`DemoApp`) is included to verify that everything works end-to-end.

---

## 2. Features (Current Backend Phase)

### Implemented

- **User management (backend model)**  
  - Java `User` class + `users` table in DB.

- **Subject management**  
  - Java `Subject` class + `subjects` table.

- **FAQ knowledge base (for future chatbot logic)**  
  - Java `Faq` class + `faq` table.  
  - Each FAQ is linked to a subject and contains keywords + an explanation.

- **Quiz questions (for future quiz module)**  
  - Java `QuizQuestion` class + `quiz_questions` table.  
  - MCQ format with options A–D and a correct answer.

- **JDBC & DAO layer**  
  - Central DB connection utility using `db.properties`.  
  - DAO classes for:
    - `User`
    - `Subject`
    - `Faq`
    - `QuizQuestion`

- **Demo console app**  
  - Inserts sample data (user, subject, FAQ, quiz question).  
  - Reads and prints data from the database.

---

## 3. Architecture

The project follows a simple layered architecture:

- **Model layer (`model/`)**  
  Plain Java classes that represent core entities in the system.

- **Data access layer (`dao/`)**  
  DAOs contain all the code needed to talk to MySQL using JDBC.

- **Utility layer (`util/`)**  
  Shared reusable helpers, currently only `DBConnectionUtil`.

- **Application layer (`app/`)**  
  Entry point for testing: `DemoApp`.

Later, a web layer (Servlets/JSP or Spring Boot) or a chatbot interface can sit on top of this.

---

## 4. Domain Model

Current domain entities:

- `User`
  - id, name, email, password, semester
- `Subject`
  - id, name, code
- `Faq`
  - id, subjectId, questionKeywords, answerText, difficulty
- `QuizQuestion`
  - id, subjectId, questionText, options A–D, correctOption, difficulty

Each is implemented as a separate Java class with:

- Private fields
- Getters and setters
- Constructors (with and without `id`)
- `toString()` for easy logging/debugging

---

## 5. Database Schema (MySQL)

Database name: `self_study_assistant`

All table creation scripts are in:

```text
sql/schema.sql
```
Main tables:

users – stores student accounts

subjects – list of subjects

faq – FAQ entries mapped to subjects

quiz_questions – MCQs linked to subjects

Foreign keys:

faq.subject_id → subjects.id

quiz_questions.subject_id → subjects.id

Foreign keys:

faq.subject_id → subjects.id

quiz_questions.subject_id → subjects.id

Tech Stack

Language: Java

Database: MySQL

Database access: JDBC (MySQL Connector/J)

Build/run: Any Java IDE or plain javac/java

ai-self-study-assistant/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/selfstudyassistant/
│       │       ├── model/
│       │       │   ├── User.java
│       │       │   ├── Subject.java
│       │       │   ├── Faq.java
│       │       │   └── QuizQuestion.java
│       │       ├── dao/
│       │       │   ├── UserDao.java
│       │       │   ├── SubjectDao.java
│       │       │   ├── FaqDao.java
│       │       │   └── QuizQuestionDao.java
│       │       ├── util/
│       │       │   └── DBConnectionUtil.java
│       │       └── app/
│       │           └── DemoApp.java
│       └── resources/
│           └── db.properties
├── sql/
│   └── schema.sql
├── .gitignore
└── README.md

src/main/java/com/selfstudyassistant/model – entity classes
src/main/java/com/selfstudyassistant/dao – DAOs for DB operations
src/main/java/com/selfstudyassistant/util – DB connection helper
src/main/java/com/selfstudyassistant/app – console entry point
src/main/resources – configuration (db.properties)
sql – DB schema script

Setup & Installation
Prerequisites

Java 8+

MySQL server running locally

MySQL Connector/J (JDBC driver) added to your classpath

Git / IDE (optional but recommended)

Clone the repository

git clone https://github.com/Harshvardhan-bajpai/ai-self-study-assistant.git
cd ai-self-study-assistant


Create the database and tables

Open your MySQL client (CLI or GUI).

Make sure you’re in the project root.

Run:
SOURCE sql/schema.sql;

This will:

Create the self_study_assistant database (if it doesn’t exist)

Create all required tables

Configure database connection

Open:
src/main/resources/db.properties

The config is:
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/self_study_assistant
db.username=root
db.password=root

Run the demo

You can run via an IDE or command line.

Option A: Using an IDE

Open/import the project in IntelliJ / Eclipse / NetBeans.

Add the MySQL JDBC driver (Connector/J) to the project’s classpath.

Run the DemoApp class:

Package: com.selfstudyassistant.app

Class: DemoApp

Option B: Using command line

Make sure the MySQL driver JAR is on the classpath.

What DemoApp Does

DemoApp performs a small end-to-end test:

Inserts a sample Subject (e.g., “Java Programming”).

Inserts a sample User.

Inserts a sample Faq linked to the subject.

Inserts a sample QuizQuestion linked to the subject.

Fetches and prints:

All users

All subjects

If everything is set up correctly, the console will show:

Inserted entities (with generated IDs)

Lists of users and subjects from the database

This confirms:

JDBC connectivity works

DAOs are functioning

Schema and config are correct

Roadmap / Next Steps

Planned future work (not yet implemented here):

Web-based UI (login, dashboard, subject selection)

Simple chatbot-like interface on top of FAQ data

Quiz module with score calculation

Basic recommendation logic:

Analyze quiz results

Suggest topics or difficulty levels to focus on

Notes

Password is currently stored as plain text in the DB for simplicity.
In a real application this should be hashed.

This repo focuses on the backend structure and database integration.
Frontend and “AI logic” will be layered on top in later phases.
