package com.example.pidev.services.ReactionProject;

import com.example.pidev.entities.Project;
import com.example.pidev.entities.ReactionProject;
import com.example.pidev.entities.User;
import com.example.pidev.repository.CommentRepository;
import com.example.pidev.repository.ProjectRepository;
import com.example.pidev.repository.ReactionProjectRepository;
import com.example.pidev.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReactionProjectService  implements IReactionProjectService{
    @Autowired
     ReactionProjectRepository reactionProjectRepository;
    UserRepository userRepository;
    ProjectRepository projectRepository;
    @Override
    public ResponseEntity<?> addReactionToProject(Integer idProject, ReactionProject reactionProject, Integer idUser) {

        Project p = projectRepository.findById(idProject).orElse(null);
        User u = userRepository.findById(idUser).orElse(null);

        reactionProject.setUser(u);
        reactionProject.setProject(p);

        reactionProjectRepository.save(reactionProject);
        return ResponseEntity.ok().body(reactionProject);
    }
}
