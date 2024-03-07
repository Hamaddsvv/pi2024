package com.example.pidev.services.Comment;

import com.example.pidev.entities.Comment;
import com.example.pidev.entities.Project;
import com.example.pidev.repository.CommentRepository;
import com.example.pidev.repository.ProjectRepository;
import com.example.pidev.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService implements  ICommentService{
    @Autowired
    CommentRepository commentRepository;
    UserRepository userRepository;
    ProjectRepository projectRepository;

    @Override
    public ResponseEntity<?> addCommentToProject(Integer idProject, Comment comment) {

            Project p = projectRepository.findById(idProject).orElse(null);

            comment.setProject(p);

            commentRepository.save(comment);
            return ResponseEntity.ok().body(comment);

        }


}

