package tn.esprit.copi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.copi.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}