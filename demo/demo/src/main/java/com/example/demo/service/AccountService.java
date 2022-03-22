package com.example.demo.service;

import com.example.demo.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {
    public Optional<Account> findAccountByName(String name);

    Account getAccountByUsername(String userName);
}
