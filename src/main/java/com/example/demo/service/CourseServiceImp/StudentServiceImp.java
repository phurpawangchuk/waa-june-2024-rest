package com.example.demo.service.CourseServiceImp;


import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    List<Student> studentList = new ArrayList<>();

    @Autowired
    private final StudentRepo studentRepo;

    @Override
    public String create(Student student) {
        studentList.add(student);
        return "Created the student.";
    }

    @Override
    public String delete(int studentId) {
       Optional<Student> studentToDelete = studentList.stream().filter(student -> student.getId() == studentId).findFirst();
        if(studentToDelete.isPresent()){
            studentList.remove(studentToDelete.get());
            return "Student deleted successfully";
        }
        return "Student not found.";
    }

    @Override
    public String update(int studentId, Student student) {
        Optional<Student> studentToUpdate = studentList.stream().filter(c -> c.getId() == studentId).findFirst();
        if(studentToUpdate.isPresent()){
            Student updateStudent = studentToUpdate.get();
            updateStudent.setFirstName(student.getFirstName());
            updateStudent.setAssignedCourses(student.getAssignedCourses());
            updateStudent.setEmail(student.getEmail());
            updateStudent.setGpa(student.getGpa());
            updateStudent.setMajor(student.getMajor());
            updateStudent.setLastName(student.getLastName());
            return "Successfully updated the student.";
        }
        return "Student not found.";
    }

    @Override
    public Student getStudentsByMajor(String major) {
        Student student = studentList.stream().filter(std -> std.getMajor().equals(major)).findFirst().get();
        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        Optional<Student> student = studentList.stream().filter(stu -> stu.getId() == studentId).findFirst();
        List<Course> assignedCourses = student.get().getAssignedCourses();
        return assignedCourses;
    }
}
