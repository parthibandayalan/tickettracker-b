package com.tickettracker.tickettrackerb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tickettracker.tickettrackerb.dto.ProjectDTO;
import com.tickettracker.tickettrackerb.dto.TicketDTO;
import com.tickettracker.tickettrackerb.entity.Project;
import com.tickettracker.tickettrackerb.entity.Roles;
import com.tickettracker.tickettrackerb.entity.Ticket;
import com.tickettracker.tickettrackerb.mappers.ProjectMapper;
import com.tickettracker.tickettrackerb.mappers.TicketMapper;
import com.tickettracker.tickettrackerb.model.CreateProjectModel;
import com.tickettracker.tickettrackerb.repositories.ProjectJpaRepository;
import com.tickettracker.tickettrackerb.repositories.UserJpaRepository;

@Service
public class ProjectService {

	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired	
	ProjectJpaRepository projectRepository;
	@Autowired
	ProjectMapper projectMapper;
	@Autowired
	UserJpaRepository userRepository;

	public List<ProjectDTO> findAll() {
//		User user = ticketRepository.findAll().get(0);
//		log.info("User Service : " + user.toString());
		List<Project> projects = projectRepository.findAll();
		
		log.info("Project Service : " + projects.toString());
		
		/*
		if(!projects.isEmpty()) {
			for(Project project:projects) {
				//log.info("Project Id : " + project.getProjectDescription().toString());
				log.info("Project Manager : " + project.getProjectManager().getUsername().toString());
			}
		}*/
		
		List<ProjectDTO> listProjectDTO = projectMapper.listOfProjectToDTO(projects);
		return listProjectDTO;
	}

	public ResponseEntity<String> createProject(CreateProjectModel receivedModel) {

		Project project = new Project();

		log.info("User Service : " + receivedModel.toString());
		
		
		if(userRepository.findByUsername(receivedModel.getProjectManager()).isPresent() && userRepository.findByUsername(receivedModel.getProjectManager()).get().getRole().equals(Roles.Manager)) {
			project.setProjectManager(userRepository.findByUsername(receivedModel.getProjectManager()).get());
			project.setProjectDescription(receivedModel.getProjectDescription());
			project.setProjectName(receivedModel.getProjectName());
			Project savedProject = projectRepository.save(project);
			if (projectRepository.findById(savedProject.getId()).isPresent())
				return ResponseEntity.ok("Project Created Successfully");
			else
				return ResponseEntity.unprocessableEntity().body("Failed Creating Project as Specified");			
			
		} else 
			return ResponseEntity.unprocessableEntity().body("Project Manager not on record");
		
		//if(receivedModel.getTickets()!=null) project.setTickets(receivedModel.getTickets());		

	}
	
	public ResponseEntity<Object> findProjectById(String id) {		
		if(projectRepository.findById(id).isPresent()) {
			Project foundProject = projectRepository.findById(id).get();
			log.info("Project Service : " + foundProject.toString());
			ProjectDTO toDTO = projectMapper.projectWithTicketsNoProjects(foundProject);
			return ResponseEntity.ok().body(toDTO);
		} else {
			return ResponseEntity.badRequest().body("Cannot find the project specified");
		}		
	}

}