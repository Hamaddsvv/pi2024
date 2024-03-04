package tn.esprit.copi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokerPlanning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "poker_cards_id")
    private Poker_Cards pokerCards;



    @OneToMany(mappedBy = "pokerPlanning")
    private List<Task> tasks;
    // Autres champs, constructeurs et méthodes omis pour la brièveté
}