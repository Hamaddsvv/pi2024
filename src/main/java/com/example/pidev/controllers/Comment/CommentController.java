package com.example.pidev.controllers.Comment;

import com.example.pidev.entities.Comment;
import com.example.pidev.services.Comment.ICommentService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController


public class CommentController {
    @Autowired
    ICommentService iCommentService;
    @PostMapping("/addComment/{idProject}")
    public ResponseEntity<?> addCommentToProject(
                                                 @PathVariable Integer idProject,
                                                 @RequestBody Comment comment
                                                 ) {
        try {
            return iCommentService.addCommentToProject( idProject,comment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'ajout du commentaire : " + e.getMessage());
        }
    }
}
