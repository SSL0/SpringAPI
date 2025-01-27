package com.example.springapi.config;

import com.example.springapi.model.Group;
import com.example.springapi.model.Student;
import com.example.springapi.repository.GroupRepository;
import com.example.springapi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        GroupRepository groupRepository) {
        return args -> {
            List<Group> groups = List.of(
                    new Group(null, "8В20", "В", 2022),
                    new Group(null, "8В21", "В", 2023)
            );
            List<Student> students = List.of(
                    new Student(null,
                            "Ivan",
                            "Ivan",
                            "Ivan",
                            groups.get(0),
                            new GregorianCalendar(2000, Calendar.MARCH, 25).getTime(),
                            'M',
                            "STUDYING"
                    ),
                    new Student(null,
                            "Jack",
                            "Jackov",
                            "Jackovich",
                            groups.get(1),
                            new GregorianCalendar(2001, Calendar.FEBRUARY, 12).getTime(),
                            'M',
                            "EXPELLED"
                    ),
                    new Student(null,
                            "sdfa",
                            "asdfa",
                            "asdf",
                            groups.get(1),
                            new GregorianCalendar(2001, Calendar.FEBRUARY, 12).getTime(),
                            'M',
                            "EXPELLED"
                    )
            );
            try {
                groupRepository.saveAllAndFlush(groups);
                studentRepository.saveAllAndFlush(students);
            } catch (DataIntegrityViolationException ignored) {
            }
        };
    }

}
