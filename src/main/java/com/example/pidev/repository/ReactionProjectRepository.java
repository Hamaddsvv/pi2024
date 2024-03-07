package com.example.pidev.repository;

import com.example.pidev.entities.ReactionProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionProjectRepository extends JpaRepository<ReactionProject,Integer> {
}
