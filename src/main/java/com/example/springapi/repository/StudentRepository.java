package com.example.springapi.repository;

import com.example.springapi.model.Group;
import com.example.springapi.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, QueryByExampleExecutor<Student> {
    Optional<List<Student>> findStudentsByGroup(Group group, Sort sort);
}
