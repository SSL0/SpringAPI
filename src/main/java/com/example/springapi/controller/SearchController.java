package com.example.springapi.controller;

import com.example.springapi.model.Student;
import com.example.springapi.service.StudentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class SearchController {
    private final StudentService studentService;

    public SearchController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(){
        List<Student> students = studentService.getStudents();

        if(students.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id){
        Student student = studentService.getStudentById(id);

        if(student == null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(student);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<?> getAllStudentsByGroup(@PathVariable long id){
        List<Student> students = studentService.getStudentsByGroupID(id);

        if(students.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(students);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> searchStudents(
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
        List<Student> students = studentService.searchStudentsWithFilter(
                id,
                firstname,
                lastname,
                surname,
                groupName,
                birthDateFrom,
                birthDateTo,
                gender,
                status,
                courseNumber);
        if(students.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(students);
    }
}
