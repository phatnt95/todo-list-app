package io.github.phatnt95.todolistapp.service.task;

import io.github.phatnt95.todolistapp.entity.Task;
import io.github.phatnt95.todolistapp.entity.User;
import io.github.phatnt95.todolistapp.repository.TaskRepository;
import io.github.phatnt95.todolistapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        //User owner = userRepository.getById(UUID.fromString("3c6f7df9-acd7-4507-9646-b352c6a3b6a8"));
//        task.setTask_owner(owner);
        return null;//taskRepository.save(task);
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
}
