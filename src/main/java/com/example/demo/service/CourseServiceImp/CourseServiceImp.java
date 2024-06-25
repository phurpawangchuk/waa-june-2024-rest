package com.example.demo.service.CourseServiceImp;


import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    List<Course> courseList = new ArrayList<>();

    @Autowired
    private final CourseRepo courseRepo;

    @Override
    public String create(Course course) {
        courseList.add(course);
        return "Created the course.";
    }

    @Override
    public String delete(int courseId) {
       Optional<Course> courseToDelete = courseList.stream().filter(course -> course.getId() == courseId).findFirst();
        if(courseToDelete.isPresent()){
            courseList.remove(courseToDelete.get());
            return "Course deleted successfully";
        }
        return "Course not found.";
    }

    @Override
    public String update(int courseId, Course course) {
        Optional<Course> courseToUpdate = courseList.stream().filter(c -> c.getId() == courseId).findFirst();
        if(courseToUpdate.isPresent()){
            Course courseUpdated = courseToUpdate.get();
            courseUpdated.setName(course.getName());
            courseUpdated.setCode(course.getCode());
            return "Successfully updated the code.";
        }
        return "Course not found.";
    }

    @Override
    public List<Course> getAll() {
        return courseList;
    }
}
