package com.example.pidev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idUser ;
    private String nomUser ;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<ReactionProject> reactionProjects;
}
