package com.example.pidev.repository;

import com.example.pidev.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
