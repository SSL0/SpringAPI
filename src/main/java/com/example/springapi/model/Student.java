package com.example.springapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
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
    private Character gender;
    private String status;

}



