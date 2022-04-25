package io.github.phatnt95.todolistapp.utils;

import io.github.phatnt95.todolistapp.entity.User;
import io.github.phatnt95.todolistapp.repository.UserRepository;
import io.github.phatnt95.todolistapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author phatnt
 * @discription
 */
public class Util {
    @Autowired
    private static UserRepository userService;

    public static User getUserByUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
        return userService.findByUsername(username).orElse(null);
    }
}
