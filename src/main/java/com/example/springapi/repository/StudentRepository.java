package com.example.springapi.repository;

import com.example.springapi.model.Group;
import com.example.springapi.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, QueryByExampleExecutor<Student> {
    Optional<List<Student>> findStudentsByGroup(Group group, Sort sort);
//
//    @Query("SELECT s FROM Student s WHERE " +
//            "(:id IS NULL OR s.id = :id) AND " +
//            "(:lastname IS NULL OR s.lastname = :lastname) AND " +
//            "(:firstname IS NULL OR s.firstname = :firstname) AND " +
//            "(:surname IS NULL OR s.surname = :surname) AND " +
//            "(:birthDateFrom IS NULL OR s.dateOfBirth >= :birthDateFrom) AND " +
//            "(:birthDateTo IS NULL OR s.dateOfBirth <= :birthDateTo) AND " +
//            "(:gender IS NULL OR s.gender = :gender) AND " +
//            "(:status IS NULL OR s.status = :status)")
//    List<Student> searchStudents(
//            @Param("id") Long id,
//            @Param("lastname") String lastName,
//            @Param("firstname") String firstName,
//            @Param("surname") String middleName,
//            @Param("birthDateFrom") Date birthDateFrom,
//            @Param("birthDateTo") Date birthDateTo,
//            @Param("gender") Character gender,
//            @Param("status") String status,
//            Sort sort
//    );

}
