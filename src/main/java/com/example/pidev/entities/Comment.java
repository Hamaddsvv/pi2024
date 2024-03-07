package com.example.pidev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date timestamp;
    @ManyToOne
    @JsonIgnore

    private  Project project;
    @ManyToOne
    @JsonIgnore
    private  User user;
}

