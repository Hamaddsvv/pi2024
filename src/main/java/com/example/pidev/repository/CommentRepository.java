package com.example.pidev.repository;

import com.example.pidev.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository <Comment,Integer> {
}
