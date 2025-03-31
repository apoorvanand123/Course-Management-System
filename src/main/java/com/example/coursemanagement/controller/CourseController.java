package com.example.coursemanagement.controller;

import com.example.coursemanagement.model.Course;
import com.example.coursemanagement.model.Student;
import com.example.coursemanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PostMapping("/{courseId}/enroll")
    public Course enrollStudent(@PathVariable String courseId, @RequestBody Student student) {
        return courseService.enrollStudent(courseId, student);
    }

    @PutMapping("/{courseId}/grade")
    public Course assignGrade(@PathVariable String courseId, @RequestParam String studentId, @RequestParam String grade) {
        return courseService.assignGrade(courseId, studentId, grade);
    }

    @PutMapping("/{courseId}/attendance")
    public Course markAttendance(@PathVariable String courseId, @RequestParam String studentId, @RequestParam boolean isPresent) {
        return courseService.markAttendance(courseId, studentId, isPresent);
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
}
