package com.example.coursemanagement.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Course {
    @Id
    private String courseId;
    private String courseName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Map<Student, String> grades = new HashMap<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Map<Student, Boolean> attendance = new HashMap<>();

    // Getters and setters

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Map<Student, String> getGrades() {
        return grades;
    }

    public void setGrades(Map<Student, String> grades) {
        this.grades = grades;
    }

    public Map<Student, Boolean> getAttendance() {
        return attendance;
    }

    public void setAttendance(Map<Student, Boolean> attendance) {
        this.attendance = attendance;
    }
}
