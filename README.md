<div id="top"><div align="center"><img src="readmeai/assets/logos/purple.svg" width="30%" alt="Project Logo"/># <code>❯ AI-POWERED SELF-STUDY ASSISTANT</code><em>A backend system designed to help students learn smarter using subjects, FAQs, and MCQ-based self-assessment.</em>

Built with: <b>Java • MySQL • JDBC</b></div><br>

---## 📌 Table of Contents- [Overview](#overview)- [Features](#features)- [Project Structure](#project-structure)  - [Project Index](#project-index)- [Getting Started](#getting-started)  - [Prerequisites](#prerequisites)  - [Installation](#installation)  - [Usage](#usage)- [Roadmap](#roadmap)- [License](#license)- [Acknowledgments](#acknowledgments)

---## 🔍 Overview

The **AI-Powered Self-Study Assistant** is a Java backend application that helps students structure and improve their learning by storing:- Student profiles- Subjects they are studying- Concept explanations in FAQ format- Quiz questions for self-practice

A console runner (`DemoApp`) tests the entire backend using JDBC, ensuring correct insert & fetch operations through Data Access Objects (DAO).

This is the **backend foundation**. A web interface and chatbot recommendation system will be built over this later.

---## ✨ Features

| Module | Description |
|--------|-------------|
| User | Maintains student information |
| Subject | Stores subject name and code |
| FAQ Knowledge Base | Explanation responses + keywords for future chatbot |
| Quiz Questions | MCQs with four options + correct answer |
| JDBC Layer | Connects with MySQL using `db.properties` |
| DAO Layer | Insert + fetch functionality for all modules |
| DemoApp | Executes a complete backend end-to-end test |

## 🧱 Project Structure

```sh
└── /
    ├── sql
    │   └── schema.sql
    └── src
        └── main
            ├── java
            │   └── com/selfstudyassistant
            │       ├── app
            │       ├── dao
            │       ├── model
            │       └── util
            └── resources

📁 Project Index (Click to Expand)

<details open>
	<summary><b><code>sql</code></b></summary>
	<blockquote>
	<table>
	<tr><td><b>schema.sql</b></td><td>Creates database, tables & foreign key relationships.</td></tr>
	</table>
	</blockquote>
</details>
<details>
	<summary><b><code>src/main/java/com/selfstudyassistant/app</code></b></summary>
	<blockquote>
	<table>
	<tr><td><b>DemoApp.java</b></td><td>Runs backend test using DAO insert + fetch operations.</td></tr>
	</table>
	</blockquote>
</details>
<details>
	<summary><b><code>src/main/java/com/selfstudyassistant/dao</code></b></summary>
	<blockquote>
	<table>
	<tr><td><b>UserDao.java</b></td><td>User database operations.</td></tr>
	<tr><td><b>SubjectDao.java</b></td><td>Subject database operations.</td></tr>
	<tr><td><b>FaqDao.java</b></td><td>FAQ database operations.</td></tr>
	<tr><td><b>QuizQuestionDao.java</b></td><td>Quiz question database operations.</td></tr>
	</table>
	</blockquote>
</details>
<details>
	<summary><b><code>src/main/java/com/selfstudyassistant/model</code></b></summary>
	<blockquote>
	<table>
	<tr><td><b>User.java</b></td><td>Encapsulates student profile.</td></tr>
	<tr><td><b>Subject.java</b></td><td>Stores subject metadata.</td></tr>
	<tr><td><b>Faq.java</b></td><td>Keywords + explanation for concept clarification.</td></tr>
	<tr><td><b>QuizQuestion.java</b></td><td>MCQ statement, options, correct answer.</td></tr>
	</table>
	</blockquote>
</details>
<details>
	<summary><b><code>src/main/java/com/selfstudyassistant/util</code></b></summary>
	<blockquote>
	<table>
	<tr><td><b>DBConnectionUtil.java</b></td><td>Returns JDBC connection using `db.properties`.</td></tr>
	</table>
	</blockquote>
</details>

---## 🚀 Getting Started

### 🔑 Prerequisites

* Java 8 or above
* MySQL Server installed
* MySQL Connector/J

### 📦 Installation

1.  Clone the repository:
    ```bash
    git clone https://github.com/Harshvardhan-bajpai/ai-self-study-assistant.git
    cd ai-self-study-assistant
    ```
2.  Create DB + Tables:
    ```sql
    SOURCE sql/schema.sql;
    ```
3.  Configure DB:
    Edit the file `src/main/resources/db.properties`
    
    Example:
    ```properties
    db.driver=com.mysql.cj.jdbc.Driver
    db.url=jdbc:mysql://localhost:3306/self_study_assistant
    db.username=root
    db.password=root
    ```

### ▶️ Usage (Run Demo)

Using IDE:

1.  Add MySQL JDBC driver to classpath
2.  Run `DemoApp.java`

Expected output:

* Inserts sample User, Subject, FAQ, QuizQuestion
* Prints retrieved data from DB

This confirms:

✔ **JDBC works**

✔ **DAOs work**

✔ **Schema is correct**

---## 🛣 Roadmap

| Status | Feature |
|--------|---------|
| 🟢 Complete | Backend: JDBC + DAO + Schema + DemoApp |
| 🔜 Upcoming | Web UI (login & dashboard) |
| 🔜 Upcoming | FAQ-based chatbot |
| 🔜 Upcoming | Quiz scoring & performance history |
| 🔮 Future | Personalized study recommendations |

---## 🛡 License

This project is intended for academic learning and backend development practice.

---## 🙌 Acknowledgments

Developed by **Harshvardhan Bajpai**

The project will evolve into a fully intelligent learning assistant with UI + chatbot in upcoming phases.

<div align="right">
	<a href="#top">🔼 Back to top</a>
</div>
