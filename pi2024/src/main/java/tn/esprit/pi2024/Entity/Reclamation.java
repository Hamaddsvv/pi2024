package Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long requestId ;
    Long userId;
    Long taskId;
    String Description ;
    String Reason;
    @Enumerated(EnumType.STRING)
    Status status;
    Date dateSubmitted;
    Date dateUpdated;

    @ManyToOne
    private User user;

}

