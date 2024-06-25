package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public String create(@RequestBody Student student){

        return studentService.create(student);
    }

    @GetMapping
    public List<Student> getAll(){

        return studentService.getAll();
    }

    @PutMapping("/{studentId}")
    public String update(@PathVariable int studentId, @RequestBody Student student){
        return studentService.update(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable int studentId){

        return studentService.delete(studentId);
    }

    @GetMapping("/{major}")
    public Student getStudentsByMajor(@PathVariable String major){

        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }
}
