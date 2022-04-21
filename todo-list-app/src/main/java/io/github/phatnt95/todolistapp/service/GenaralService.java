package io.github.phatnt95.todolistapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author phatnt
 * @discription
 */


public interface GenaralService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
