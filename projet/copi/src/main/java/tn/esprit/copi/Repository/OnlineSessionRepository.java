package tn.esprit.copi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.copi.Entity.OnlineSession;

public interface OnlineSessionRepository  extends JpaRepository<OnlineSession, Long> {
}
