# Java URL Shortener (no framework)

A tiny URL shortener built with **Java 17**, the built-in `HttpServer`, and an **H2 in-memory database**—no frameworks.  
Includes **JUnit 5** tests and simple endpoints to shorten and resolve URLs.

## Why this project?
- Shows core **Java** skills without Spring/extra frameworks
- Uses **JDBC** with **H2** to demonstrate SQL + testing
- Clean, minimal code you can explain in interviews

---

## Features
- `POST /shorten` — create a short code for a target URL
- `GET /{code}` — redirect (302) to the original URL
- Random 6-hex short codes (e.g., `a9f3b2`)
- JUnit tests for the repository layer

---

## Tech Stack
- Java 17
- H2 (in-memory) via JDBC
- JUnit 5

---

## Project structure
