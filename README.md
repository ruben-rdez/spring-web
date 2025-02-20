# Spring Web

This is a Spring Boot application for managing mobile devices. It provides a RESTful API for CRUD operations on students.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Running Tests](#running-tests)


## Features

- Create, read, update, and delete students
- REST API
- MySQL database integration

## Requirements

- Java 21
- Spring Boot 3.4.2
- Spring Data JPA
- Swagger
- Lombok
- Model Mapper
- Maven
- MySQL
- Git
- GitHub

## Installation

1. Clone the repository:
   git clone https://github.com/ruben-rdez/spring-web.git

2. Configure the database in application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/studentsdb?createDatabaseIfNotExist=true
   spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
   spring.datasource.username=username
   spring.datasource.password=password

3. Build the project:
   mvn clean package

## Usage

1. Run the application:
   mvn spring-boot:run

2. The application will be available at .

## API Endpoints

- `GET /api/students` - Get all students
- `GET /api/students/{id}` - Get student by ID
- `POST /api/students` - Add a new student
- `PUT /api/students/{id}` - Update an existing student
- `DELETE /api/students/{id}` - Delete a student

## Running Tests

To run the tests, use the following command:
mvn test