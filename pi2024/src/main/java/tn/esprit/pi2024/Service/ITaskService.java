package tn.esprit.pi2024.Service;

import org.springframework.scheduling.config.Task;

import java.util.List;

public interface ITaskService {
    public List<Task> retrieveAllTasks();
    public Task retrieveTask(Long taskId);
    public Task addTask(Task t);
    public void removeTask(Long taskId);
    public Task modifyTask(Task Task);
}
