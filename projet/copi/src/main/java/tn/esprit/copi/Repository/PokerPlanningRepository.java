package tn.esprit.copi.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.copi.Entity.PokerPlanning;

@Repository
public interface PokerPlanningRepository extends JpaRepository<PokerPlanning, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire
}