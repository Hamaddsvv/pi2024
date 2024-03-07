package com.example.pidev.services.Comment;

import com.example.pidev.entities.Comment;
import org.springframework.http.ResponseEntity;

public interface ICommentService {
    ResponseEntity<?> addCommentToProject(Integer idProject, Comment comment);

}
