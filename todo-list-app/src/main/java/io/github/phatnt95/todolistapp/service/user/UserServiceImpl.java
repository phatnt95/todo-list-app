package io.github.phatnt95.todolistapp.service.user;

import io.github.phatnt95.todolistapp.entity.ERole;
import io.github.phatnt95.todolistapp.entity.Role;
import io.github.phatnt95.todolistapp.entity.User;
import io.github.phatnt95.todolistapp.repository.RoleRepository;
import io.github.phatnt95.todolistapp.repository.UserRepository;
//import io.github.phatnt95.todolistapp.security.model.UserPrinciple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

/**
 * @author phatnt
 * @discription
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null){
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        Collection<Role> roles = new ArrayList<>();
        if (!user.getRoles().isEmpty()) {
            user.getRoles().forEach(role -> {
                Role r = roleRepository.findByName(role.getName());
                if (r != null) {
                    roles.add(r);
                }
            });
            user.setRoles(roles);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.set_acctive(true);
        if (user.getId() != null) {
            user.setLastModifiedTime(LocalDate.now());
        } else {
            user.setCreationTime(LocalDate.now());
        }
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
