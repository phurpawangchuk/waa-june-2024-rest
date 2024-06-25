package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Operation(summary = "Get All Courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the courses",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Course.class)) }),
            @ApiResponse(responseCode = "404", description = "Courses not found",
                    content = @Content)
    })
    @GetMapping
    public List<Course> getAll(){
        return null;
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<String> update(@PathVariable int courseId){
    return null;
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> delete(@PathVariable int courseId){
    return null;
    }

    @GetMapping("/{studentId}")
    public Student getCoursesByStudentId(@PathVariable  int studentId){
        return null;
    }
}
