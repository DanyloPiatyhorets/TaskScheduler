package com.example.TaskScheduler.repo;

import com.example.TaskScheduler.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
