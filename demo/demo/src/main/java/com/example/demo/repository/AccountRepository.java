package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
//    Optional<Account> finAccountByUserName(String name);

    Optional<Account> findByUserName(String username);
}
