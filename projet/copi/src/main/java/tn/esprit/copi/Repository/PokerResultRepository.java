package tn.esprit.copi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.copi.Entity.Poker_Result;

public interface PokerResultRepository extends JpaRepository<Poker_Result, Long> {
}
