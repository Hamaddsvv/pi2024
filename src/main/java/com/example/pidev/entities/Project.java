package com.example.pidev.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idProject")
  private Integer idProject ;
    private String Title;
    private  String Description ;
    private  String Prototype ;
    private  String Image ;
    @Enumerated(EnumType.STRING)
    private  EtatProject etatProject;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Date_debut;
    @Temporal(TemporalType.TIMESTAMP)
    private  Date Datefin_prevu ;


    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
  private List<Comment> comments;
  @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
  private List<ReactionProject> reactionProjects;
}
