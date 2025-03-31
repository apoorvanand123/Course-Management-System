package com.example.coursemanagement.service;

import com.example.coursemanagement.exception.ResourceNotFoundException;
import com.example.coursemanagement.model.Course;
import com.example.coursemanagement.model.Student;
import com.example.coursemanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course enrollStudent(String courseId, Student student) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        course.getGrades().put(student, "Not Graded");
        course.getAttendance().put(student, false);
        return courseRepository.save(course);
    }

    public Course assignGrade(String courseId, String studentId, String grade) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        Student student = new Student();
        student.setStudentId(studentId);
        course.getGrades().put(student, grade);
        return courseRepository.save(course);
    }

    public Course markAttendance(String courseId, String studentId, boolean isPresent) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        Student student = new Student();
        student.setStudentId(studentId);
        course.getAttendance().put(student, isPresent);
        return courseRepository.save(course);
    }

    public Course getCourse(String courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
