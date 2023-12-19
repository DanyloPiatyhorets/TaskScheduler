package com.example.TaskScheduler.repo;


import com.example.TaskScheduler.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
