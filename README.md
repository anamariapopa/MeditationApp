# MeditationApp 

A personalized wellness and mindfulness platform built with **Java** and **Spring Boot**. The application allows users to manage their meditation journey through a hybrid system of predefined library sessions and fully customizable personal sessions.

> **Status:** Project is currently in active development and refinement.

---

##  Key Features (Backend Core)

* **User Management:** Complete registration and login logic with data validation.
* **Customizable Sessions:** Users can create personalized meditation sessions  or choose from a library of templates.
* **Persistent Storage:** Data persistence implemented using **Spring Data JPA** and **H2 Database** (in-memory for development).

---

## Architecture & Technologies

The project follows a **Layered Architecture** to ensure high maintainability and scalability:

* **Models:** JPA Entities mapped to database tables, using **Lombok** `@Data` to ensure clean and readable code.
* **Repositories:** Data Access Object (DAO) layer using `JpaRepository` for automated SQL queries.
* **Services:** The Business Logic layer where all validations and core rules are processed.


---

## Tech Stack

* **Language:** Java 25
* **Framework:** Spring Boot 3.x
* **Database:** H2 (Development)
* **ORM:** Hibernate / Spring Data JPA
* **Utilities:** Lombok (Boilerplate reduction)
* **Tooling:** Maven

---

## Roadmap

- Adding a **User Progress Module**.
- Integration with a Frontend framework.
- Implementing AI-powered suggestions for session improvement.

