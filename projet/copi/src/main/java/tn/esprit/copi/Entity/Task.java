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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "poker_card_id")
    private Poker_Cards pokerCard;

    @ManyToOne
    @JoinColumn(name = "poker_planning_id")
    private PokerPlanning pokerPlanning;

    @OneToMany(mappedBy = "task")
    private List<TaskSession> taskSessions;
}
