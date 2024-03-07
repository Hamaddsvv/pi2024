package com.example.pidev.services.Prject;

import com.example.pidev.entities.Project;
import com.example.pidev.repository.ProjectRepository;
import com.example.pidev.services.ICrudeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class ProjectService  implements ICrudeService<Project,Integer>, IProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll() ;   }

    @Override
    public Project retrieveItem(Integer idItem) {
        return projectRepository.findById(idItem).get();
    }

    @Override
    public Project add(Project class1) {
        return projectRepository.save(class1);
    }

    @Override
    public void delete(Integer i) {
        projectRepository.deleteById(i);

    }

    @Override
    public Project update(Project project, Integer id) {
        Optional<Project> existingProjectOptional = projectRepository.findById(id);

        if (existingProjectOptional.isPresent()) {
            Project existingProject = existingProjectOptional.get();
            existingProject.setTitle(project.getTitle());
            existingProject.setDescription(project.getDescription());
            existingProject.setPrototype(project.getPrototype());
            existingProject.setDate_debut(project.getDate_debut());
            existingProject.setDatefin_prevu(project.getDatefin_prevu());
            existingProject.setEtatProject(project.getEtatProject());

            return projectRepository.save(existingProject);
        } else {
            return null;
        }
    }



}
