package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student phat = new Student(1L, "Phat Nguyen", "phatnguyen.uit95@gmail.com", LocalDate.of(1995, Month.FEBRUARY, 24));
            repository.saveAll(List.of(phat));
        };
    }
}
