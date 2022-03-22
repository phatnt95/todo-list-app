package com.example.demo.student;

import com.example.demo.model.Account;
import com.example.demo.model.Role;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(RoleRepository repository, AccountRepository accountRepository) {
        return args -> {
            Role admin = new Role(1L, "ADMIN", "admin");
            Role user = new Role(1L, "USER", "user");
            repository.saveAll(List.of(admin, user));
        };
    }
}
