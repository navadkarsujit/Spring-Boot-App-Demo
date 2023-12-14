package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo){
        return args -> {
            Student sujit = new Student(
                    "Sujit",
                    "Sujit@gmail.com",
                    LocalDate.of(2002, APRIL, 17)
            );
            Student sumit = new Student(
                    "Sumit",
                    "Sumit@gmail.com",
                    LocalDate.of(2001, APRIL, 07)
            );
            repo.saveAll(
                    List.of(sujit,sumit)
            );
        };
    }

}
