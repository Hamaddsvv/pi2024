package tn.esprit.copi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.copi.Entity.TaskSession;
import tn.esprit.copi.Repository.TaskSessionRepository;

import java.util.List;

@Service
public class TaskSessionService {

    @Autowired
    private TaskSessionRepository taskSessionRepository;

    public List<TaskSession> getAllTaskSessions() {
        return taskSessionRepository.findAll();
    }

    public TaskSession getTaskSessionById(Long id) {
        return taskSessionRepository.findById(id).orElse(null);
    }

    public TaskSession addTaskSession(TaskSession taskSession) {
        // Logique d'ajout de session de tâche ici
        return taskSessionRepository.save(taskSession);
    }

    public TaskSession updateTaskSession(Long id, TaskSession updatedTaskSession) {
        // Logique de mise à jour de session de tâche ici
        return taskSessionRepository.save(updatedTaskSession);
    }

    public void deleteTaskSession(Long id) {
        taskSessionRepository.deleteById(id);
    }
}