package tn.esprit.copi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.copi.Entity.TaskSession;
import tn.esprit.copi.services.TaskSessionService;

import java.util.List;

@RestController
@RequestMapping("/task-sessions")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskSessionController {

    @Autowired
    private TaskSessionService taskSessionService;

    @GetMapping("/getAll")
    public List<TaskSession> getAllTaskSessions() {
        return taskSessionService.getAllTaskSessions();
    }

    @GetMapping("/get/{id}")
    public TaskSession getTaskSessionById(@PathVariable Long id) {
        return taskSessionService.getTaskSessionById(id);
    }

    @PostMapping("/add")
    public TaskSession addTaskSession(@RequestBody TaskSession taskSession) {
        return taskSessionService.addTaskSession(taskSession);
    }

    @PutMapping("/put/{id}")
    public TaskSession updateTaskSession(@PathVariable Long id, @RequestBody TaskSession updatedTaskSession) {
        return taskSessionService.updateTaskSession(id, updatedTaskSession);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskSession(@PathVariable Long id) {
        taskSessionService.deleteTaskSession(id);
    }
}