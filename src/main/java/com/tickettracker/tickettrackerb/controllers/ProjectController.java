package com.tickettracker.tickettrackerb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tickettracker.tickettrackerb.dto.ProjectDTO;
import com.tickettracker.tickettrackerb.model.CreateProjectModel;
import com.tickettracker.tickettrackerb.service.ProjectService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ProjectController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ProjectService projectService;

	@GetMapping("/projects")
	List<ProjectDTO> getProjects() {
		logger.info("Check Point for Debug");
		return projectService.findAll();
	}

	@GetMapping("/project/{id}")
	ResponseEntity<Object> getProjectById(@PathVariable String id) {
		return projectService.findProjectById(id);
	}
	
	//return project where the user is a project manager
	@GetMapping("/project/user/{id}")
	ResponseEntity<Object> getProjectByUserId(@PathVariable String id) {
		return projectService.findProjectsByUserId(id);
	}

	@PostMapping("/project/create")
	ResponseEntity<String> addProject(@RequestBody @Valid CreateProjectModel createModel) throws Exception {

		return projectService.createProject(createModel);

	}

}