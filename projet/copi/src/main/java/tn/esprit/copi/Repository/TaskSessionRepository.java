package tn.esprit.copi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.copi.Entity.TaskSession;

public interface TaskSessionRepository extends JpaRepository<TaskSession, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}