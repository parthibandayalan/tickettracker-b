package com.tickettracker.tickettrackerb.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tickettracker.tickettrackerb.dto.ProjectDTO;
import com.tickettracker.tickettrackerb.entity.User;
import com.tickettracker.tickettrackerb.model.CreateProjectModel;
import com.tickettracker.tickettrackerb.service.ProjectService;
import com.tickettracker.tickettrackerb.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ProjectController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ProjectService projectService;
	@Autowired
	UserService userService;

	@GetMapping("/projects")
	List<ProjectDTO> getProjects() {
		logger.info("Check Point for Debug");
		return projectService.findAll();
	}

	@GetMapping("/project/{id}")
	ResponseEntity<Object> getProjectById(@PathVariable String id) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String username = authentication.getName();
		logger.info("Username : "+username);
		return projectService.findProjectById(id);
	}
	
	
	//return projects managed by a 
	@GetMapping("/project/manager/{username}")
	ResponseEntity<Object> getProjectByUsername(@PathVariable String username){ 
		
		Optional<User> user = userService.findByUsername(username);
		
		if(user.isPresent()) {
			return projectService.findProjectsByUserId(user.get().getId().toString());
		} else {
			return ResponseEntity.unprocessableEntity().body("Username doesnt exist");
		}
		
	}
	
	//return project where the user is a project manager
	@GetMapping("/project/user/{id}")
	ResponseEntity<Object> getProjectByUserId(@PathVariable String id) {
		logger.info("Received Username : " + id.toString());
		return projectService.findProjectsByUserId(id);
	}

	@PostMapping("/project/create")
	ResponseEntity<String> addProject(@RequestBody @Valid CreateProjectModel createModel) throws Exception {

		return projectService.createProject(createModel);

	}
	
	@PostMapping("/project/remove/contributors")
	ResponseEntity<String> removeContributor(@RequestBody Map<String,Object> payload){
		logger.info("Caught request : " + payload.toString());
		List<Integer> userIds = (List<Integer>) payload.get("users");
		String projectId = (String) payload.get("projectId");
		String managerUsername = (String) payload.get("manager");
		return projectService.removeContributors(managerUsername,projectId,userIds);
	}
	
	@PostMapping("/project/add/contributors")
	ResponseEntity<String> addContributor(@RequestBody Map<String,Object> payload){
		logger.info("Caught request : " + payload.toString());
		List<Integer> userIds = (List<Integer>) payload.get("users");
		String projectId = (String) payload.get("projectId");
		String managerUsername = (String) payload.get("manager");
		return projectService.addContributors(managerUsername,projectId,userIds);
	}
	
	@PostMapping("/project/available/contributors")
	public ResponseEntity<Object> getAvailableContributors(@RequestBody Map<String,Object> payload){
		String projectId = (String) payload.get("projectId");
		String managerUsername = (String) payload.get("manager");
		return projectService.getAvailableContributors(managerUsername,projectId);
	}

}