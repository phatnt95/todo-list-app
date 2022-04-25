package io.github.phatnt95.todolistapp.service.task;

import io.github.phatnt95.todolistapp.entity.Task;
import io.github.phatnt95.todolistapp.entity.User;
import io.github.phatnt95.todolistapp.repository.TaskRepository;
import io.github.phatnt95.todolistapp.repository.UserRepository;
import io.github.phatnt95.todolistapp.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author phatnt
 * @discription
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Optional<Set<Task>> findAllActiveTask() {
        return Optional.empty();
    }

    @Override
    public Optional<Set<Task>> findAllTaskByType(String type) {
        return Optional.empty();
    }
}
