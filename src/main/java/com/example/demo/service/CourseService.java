package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    String create(Course couse);
    String delete(int courseId);
    String update(int courseId, Course course);
    Course getCoursesByStudentId(int studentId);
    List<Course> getAll();
}
