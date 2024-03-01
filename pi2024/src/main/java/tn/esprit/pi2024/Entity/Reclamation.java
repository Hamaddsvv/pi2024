package tn.esprit.pi2024.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long reclamationId ;
    String Description ;
    String Reason;
    @Enumerated(EnumType.STRING)
    Status status;
    Date dateSubmitted;
    Date dateUpdated;

    @ManyToOne
    private User user;

}

