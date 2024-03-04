package tn.esprit.copi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.copi.Entity.SessionParticipant;

public interface SessionParticipantRepository extends JpaRepository<SessionParticipant, Long> {
}
