package tn.esprit.copi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "session_participants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_session_id")
    private TaskSession taskSession;
    @ManyToOne
    @JoinColumn(name = "online_session_id")
    private OnlineSession onlineSession;
}
