package tn.esprit.copi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.copi.Entity.Poker_Cards;

public interface PockerRepository extends JpaRepository<Poker_Cards, Long> {
    // You can add custom query methods if needed
}
