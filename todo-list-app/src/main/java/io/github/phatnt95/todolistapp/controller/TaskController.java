package io.github.phatnt95.todolistapp.controller;

import io.github.phatnt95.todolistapp.entity.Task;
import io.github.phatnt95.todolistapp.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author phatnt
 * @discription
 */

@RestController
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.save(task));
    }

    @GetMapping("/get")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(taskService.findAll());
    }
}
