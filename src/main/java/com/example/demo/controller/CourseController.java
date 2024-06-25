package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public String create(@RequestBody Course course){
        return courseService.create(course);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @PutMapping("/{courseId}")
    public String update(@PathVariable int courseId, @RequestBody Course course){
        return courseService.update(courseId,course);
    }

    @DeleteMapping("/{courseId}")
    public String delete(@PathVariable int courseId){
        return courseService.delete(courseId);
    }
}
