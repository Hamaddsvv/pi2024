package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="userstory_id")
    private UserStory userstory_id;
    @Column
    private String title;
    @Column
    private String description;

    public UserStory getUserstory_id() {
        return userstory_id;
    }

    public void setUserstory_id(UserStory userstory_id) {
        this.userstory_id = userstory_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
