package com.jrp.pma.api.controllers;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

    @Autowired
    ProjectRepository proRepo;

    @GetMapping
    public Iterable<Project> getProjects() {
        return proRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Project getProjectById(@PathVariable("id") Long id) {
        return proRepo.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Valid Project project) {
        return proRepo.save(project);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Project update(@RequestBody @Valid Project project) {
        return proRepo.save(project);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Project partialUpdate(@PathVariable("id") Long id,
                                 @RequestBody @Valid Project project) {
        Project pro = proRepo.findById(id).get();

        if (project.getDescription() != null) {
            pro.setDescription(project.getDescription());
        }

        if (project.getName() != null) {
            pro.setName(project.getName());
        }

        if (project.getStage() != null) {
            pro.setStage(project.getStage());
        }
        return proRepo.save(pro);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        try {
            proRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {

        }
    }

}
