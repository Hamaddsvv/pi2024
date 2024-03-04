package tn.esprit.copi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poker_Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "online_session_id")
    private OnlineSession onlineSession;

    @ManyToOne
    @JoinColumn(name = "poker_card_id")
    private Poker_Cards pokerCard;
}
