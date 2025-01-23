package com.example.springapi.controller;

import com.example.springapi.model.Group;
import com.example.springapi.model.Student;
import com.example.springapi.service.StudentService;
import com.google.gson.Gson;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {
    private final StudentService studentService;
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

    @GetMapping("/filter")
    public List<Student> searchStudents(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String groupName,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date birthDateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date birthDateTo,
            @RequestParam(required = false) Character gender,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Integer courseNumber
    ) {
        return studentService.searchStudentsWithFilter(id, firstname, lastname, surname, groupName, birthDateFrom, birthDateTo, gender,status);
    }
}
