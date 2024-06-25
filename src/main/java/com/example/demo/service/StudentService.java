package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    String create(Student student);
    String delete(int studentId);
    String update(int studentId, Student student);
    Student getStudentsByMajor(String major);
    List<Student> getAll();
    List<Course> getCoursesByStudentId(int studentId);
}
