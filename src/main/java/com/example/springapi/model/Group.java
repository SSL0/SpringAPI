package com.example.springapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "groups")
public class Group {
    @Id
    @SequenceGenerator(
            name = "groups_id_seq",
            sequenceName = "groups_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groups_id_seq"
    )
    private Long id;
    private String name;
    private String subdivision;

    public Group(Long id, String name, String subdivision, int yearOfRecruitment) {
        this.id = id;
        this.name = name;
        this.subdivision = subdivision;
        this.yearOfRecruitment = yearOfRecruitment;
    }

    private int yearOfRecruitment;
}
