package tn.esprit.copi.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.copi.Entity.Task;
import tn.esprit.copi.Repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/getAll")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/put/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        if (taskRepository.existsById(id)) {
            updatedTask.setId(id);
            return taskRepository.save(updatedTask);
        } else {
            // Gérer le cas où la tâche n'existe pas
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}