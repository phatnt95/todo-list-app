package io.github.phatnt95.todolistapp.repository;

import io.github.phatnt95.todolistapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author phatnt
 * @discription
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
