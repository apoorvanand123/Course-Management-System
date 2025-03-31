# Course-Management-System
A robust software solution for course administration and student engagement.

## Overview

The Course Management System is designed to streamline various aspects of learning programs, including course creation, student enrollment, grading, attendance tracking, and course scheduling.

## Key Features

- **Course Creation**: Create and manage courses.
- **Student Enrollment**: Enroll students in courses.
- **Grading System**: Assign grades to students.
- **Attendance Tracking**: Track student attendance.
- **Course Scheduling**: Schedule courses (future implementation).

## Technologies Used

- **Spring Boot**: For building the application.
- **Spring Data JPA**: For database interactions.
- **MySQL**: As the relational database.
- **Hibernate**: For ORM (Object-Relational Mapping).

## How to Run

1. **Set Up Database**:
   - Install MySQL and create a database named `your_database`.
   - Create tables using the following SQL script:
     ```sql
     CREATE TABLE Students (
         studentId VARCHAR(10) PRIMARY KEY,
         studentName VARCHAR(50)
     );

     CREATE TABLE Courses (
         courseId VARCHAR(10) PRIMARY KEY,
         courseName VARCHAR(50)
     );

     CREATE TABLE Enrollments (
         courseId VARCHAR(10),
         studentId VARCHAR(10),
         grade VARCHAR(2),
         attendance BOOLEAN,
         FOREIGN KEY (courseId) REFERENCES Courses(courseId),
         FOREIGN KEY (studentId) REFERENCES Students(studentId)
     );
     ```

2. **Configure Application Properties**:
   - Open `src/main/resources/application.properties` and update the database connection details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Build and Run the Application**:
   - Navigate to the project directory and build the application using Maven:
     ```sh
     mvn clean install
     ```
   - Run the application:
     ```sh
     mvn spring-boot:run
     ```

4. **Access the Application**:
   - The application will be accessible at `http://localhost:8080`.

## API Endpoints

### Courses

- **Create Course**: `POST /courses`
  - Request Body: `{ "courseId": "C001", "courseName": "Introduction to Java" }`

- **Enroll Student**: `POST /courses/{courseId}/enroll`
  - Request Body: `{ "studentId": "S001", "studentName": "Alice" }`

- **Assign Grade**: `PUT /courses/{courseId}/grade`
  - Request Params: `studentId=S001&grade=A`

- **Mark Attendance**: `PUT /courses/{courseId}/attendance`
  - Request Params: `studentId=S001&isPresent=true`

- **Get Course**: `GET /courses/{courseId}`

- **Get All Courses**: `GET /courses`

### Students

- **Create Student**: `POST /students`
  - Request Body: `{ "studentId": "S001", "studentName": "Alice" }`

- **Get Student**: `GET /students/{studentId}`

- **Get All Students**: `GET /students`

## Future Enhancements

- Integrate with a front-end framework for a user-friendly interface.
- Implement course scheduling features.
- Add authentication and authorization for secure access.
