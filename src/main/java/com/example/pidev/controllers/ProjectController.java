package com.example.pidev.controllers;

import com.example.pidev.entities.Project;
import com.example.pidev.services.Prject.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController

@CrossOrigin(origins = "*")
public class ProjectController {
    @Autowired
    ProjectService projectService ;
    @PostMapping("/add-Project")
    @ResponseBody
    public Project addProject(@RequestBody Project b) {

        return projectService.add(b);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get_all_Projects")
    public List<Project> findAll() {
        return projectService.findAll();
    }


    @PutMapping("/updateProject/{id}")
    public Project update(@RequestBody Project Project ,@PathVariable("id") Integer id) {
        return projectService.update(Project,id);
    }
    @GetMapping("/getProject/{projectId}")
    public Project findProjectById(@PathVariable("projectId") Integer projectId) {
        return projectService.retrieveItem(projectId);
    }

    @DeleteMapping("/deleteProject/{ProjectId}")
    public void delete(@PathVariable("ProjectId") Integer ProjectId) {
        projectService.delete(ProjectId);
    }
}
