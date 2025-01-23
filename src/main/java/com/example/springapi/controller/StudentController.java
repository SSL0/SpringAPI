package com.example.springapi.controller;

import com.example.springapi.service.StudentService;
import com.example.springapi.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    @GetMapping
    public List<Student>  getStudents(){
        return studentService.getStudents();
    }

}
