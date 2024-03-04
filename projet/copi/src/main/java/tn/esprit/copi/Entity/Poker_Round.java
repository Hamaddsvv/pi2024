package tn.esprit.copi.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.copi.Entity.Poker_Cards;
import tn.esprit.copi.Entity.SessionParticipant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poker_Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_participant_id")
    private SessionParticipant sessionParticipant;

    @ManyToOne
    @JoinColumn(name = "poker_card_id")
    private Poker_Cards pokerCard;

    // Autres champs comme la date, etc.
}