package io.github.phatnt95.todolistapp.service.task;

import io.github.phatnt95.todolistapp.entity.Task;
import io.github.phatnt95.todolistapp.service.GenaralService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author phatnt
 * @discription
 */

public interface TaskService extends GenaralService<Task> {
    Optional<Set<Task>> findAllActiveTask();

    @Query("select t from task t where t.type = ?0")
    Optional<Set<Task>> findAllTaskByType(String type);
}
