package com.example.pidev.services.ReactionProject;

import com.example.pidev.entities.Comment;
import com.example.pidev.entities.ReactionProject;
import org.springframework.http.ResponseEntity;

public interface IReactionProjectService{
    ResponseEntity<?> addReactionToProject (Integer idProject , ReactionProject reactionProject, Integer idUser );
}
