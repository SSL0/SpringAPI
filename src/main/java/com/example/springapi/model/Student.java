package com.example.springapi.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Table(name = "students")
@JsonSerialize
@JsonDeserialize
public class Student {
    @Id
    @SequenceGenerator(
            name = "students_id_seq",
            sequenceName = "students_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "students_id_seq"
    )
    private Long id;

    private String lastname;
    private String firstname;
    private String surname;

    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    private Date dateOfBirth;
    private char gender;
    private String status;

    public Student(Long id, String lastName, String firstName, String surname, Group group, Date dateOfBirth, char gender, String status) {
        this.id = id;
        this.lastname = lastName;
        this.firstname = firstName;
        this.surname = surname;
        this.group = group;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.status = status;
    }

    public Student() {

    }
}
