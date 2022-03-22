package com.example.demo.service;

import com.example.demo.model.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService {
    public Optional<Role> findAllRole();
}
