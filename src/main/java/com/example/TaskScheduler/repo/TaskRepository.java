package com.example.TaskScheduler.repo;

import com.example.TaskScheduler.models.Task;
import com.example.TaskScheduler.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Modifying
    @Query("DELETE FROM Task task WHERE task.id = :taskId")
    void deleteTaskById(@Param("taskId") Long taskId);
}
