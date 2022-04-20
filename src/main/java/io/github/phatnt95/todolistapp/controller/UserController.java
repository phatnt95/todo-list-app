package io.github.phatnt95.todolistapp.controller;

import io.github.phatnt95.todolistapp.entity.Role;
import io.github.phatnt95.todolistapp.entity.User;
import io.github.phatnt95.todolistapp.service.user.RoleService;
import io.github.phatnt95.todolistapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author phatnt
 * @discription
 */

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/save-role")
    public ResponseEntity<?> save(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(userService.findAll());
    }


}
