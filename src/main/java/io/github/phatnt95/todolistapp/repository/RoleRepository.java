package io.github.phatnt95.todolistapp.repository;

import io.github.phatnt95.todolistapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author phatnt
 * @discription
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
