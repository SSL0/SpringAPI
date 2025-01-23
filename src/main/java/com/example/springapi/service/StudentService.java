package com.example.springapi.service;

import com.example.springapi.model.Group;
import com.example.springapi.model.Student;
import com.example.springapi.repository.GroupRepository;
import com.example.springapi.repository.StudentRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final Sort sortConditions =
            Sort.by(Sort.Direction.ASC, "lastname")
                .and(Sort.by(Sort.Direction.ASC, "firstname"))
                .and(Sort.by(Sort.Direction.ASC, "surname"));

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


        List<Student> students = studentRepository.findStudentsByGroup(group, sortConditions).orElse(null);

        if (students == null) return new ArrayList<>();

        return students;
    }

    public List<Student> searchStudentsWithFilter(
            Long id,
            String firstname,
            String lastname,
            String surname,
            String groupName,
            Date birthDateFrom,
            Date birthDateTo,
            Character gender,
            String status) {
        Group group = groupRepository.findByName(groupName).orElse(null);

        Student studentExample = Student.builder()
                .id(id)
                .firstname(firstname)
                .lastname(lastname)
                .surname(surname)
                .group(group)
                .gender(gender)
                .status(status)
                .build();
        List<Student> list = studentRepository.findAll(Example.of(studentExample), sortConditions);
        return list;
    }
}
