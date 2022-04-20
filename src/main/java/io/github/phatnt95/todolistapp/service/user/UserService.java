package io.github.phatnt95.todolistapp.service.user;

import io.github.phatnt95.todolistapp.entity.User;
import io.github.phatnt95.todolistapp.service.GenaralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author phatnt
 * @discription
 */
public interface UserService extends GenaralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
