package com.example.springapi.controller;

import com.example.springapi.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class SearchController {
    private final StudentService studentService;
    ObjectMapper mapper = new ObjectMapper();
    Gson gson = new Gson();

    public SearchController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getStudents(){
        return gson.toJson(studentService.getStudents());
    }

    @GetMapping("/students/{id}")
    public String getStudent(@PathVariable long id){
        return gson.toJson(studentService.getStudentById(id));
    }

    @GetMapping("/groups/{id}")
    public String getAllStudentsByGroup(@PathVariable long id){
        return gson.toJson(studentService.getStudentsByGroupID(id));
    }
}
