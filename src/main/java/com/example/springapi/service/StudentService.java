package com.example.springapi.service;

import com.example.springapi.model.Group;
import com.example.springapi.model.Student;
import com.example.springapi.repository.GroupRepository;
import com.example.springapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentsByGroupID(long groupID){
        Group group = groupRepository.findById(groupID).orElse(null);
        List<Student> students = studentRepository.findStudentsByGroup(group).orElse(null);

        if (students == null) return new ArrayList<>();

        students.sort(Comparator
                .comparing(Student::getLastname)
                .thenComparing(Student::getFirstname)
                .thenComparing(Student::getSurname)
        );
        return students;
    }
}
