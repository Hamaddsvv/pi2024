package com.example.pidev.controllers.ReactionProject;

import com.example.pidev.entities.Comment;
import com.example.pidev.entities.ReactionProject;
import com.example.pidev.services.Comment.ICommentService;
import com.example.pidev.services.ReactionProject.IReactionProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController


public class ReactionProjectController {
    @Autowired
    IReactionProjectService iReactionProjectService;
    @PostMapping("/addReaction/{idProject}/{idUser}")
    public ResponseEntity<?> addReactionProjectToPrject(
            @PathVariable Integer idProject,
            @RequestBody ReactionProject reactionProject,
            @PathVariable Integer idUser) {
        try {
            return iReactionProjectService.addReactionToProject( idProject,reactionProject, idUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'ajout du commentaire : " + e.getMessage());
        }
    }
}


