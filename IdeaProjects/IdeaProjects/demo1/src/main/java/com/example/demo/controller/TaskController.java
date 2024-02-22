package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.entity.UserStory;
import com.example.demo.exceptions.TaskNotFoundException;
import com.example.demo.exceptions.UserStoryNotFoundException;
import com.example.demo.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository taskRepository) {
        this.repository = taskRepository;
    }
    @GetMapping("/task")
    List<Task> getAll() {
        return repository.findAll();
    }
    @PostMapping("/task")
    Task newTask(@RequestBody Task story) {
        return repository.save(story);
    }
    @GetMapping("/task/{id}")
    Task getOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
    @PutMapping("/task/{id}")
    Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

        return repository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    task.setUserstory_id(newTask.getUserstory_id());
                    return repository.save(task);
                })
                .orElseThrow(() -> new UserStoryNotFoundException(id));
    }
    @DeleteMapping("/task/{id}")
    void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
