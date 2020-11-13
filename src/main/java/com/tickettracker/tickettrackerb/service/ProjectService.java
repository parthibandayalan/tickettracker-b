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
import com.tickettracker.tickettrackerb.entity.Ticket;
import com.tickettracker.tickettrackerb.mappers.ProjectMapper;
import com.tickettracker.tickettrackerb.mappers.TicketMapper;
import com.tickettracker.tickettrackerb.model.CreateProjectModel;
import com.tickettracker.tickettrackerb.repositories.ProjectJpaRepository;

@Service
public class ProjectService {

	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired	
	ProjectJpaRepository projectRepository;
	@Autowired
	ProjectMapper projectMapper;

	public List<ProjectDTO> findAll() {
//		User user = ticketRepository.findAll().get(0);
//		log.info("User Service : " + user.toString());
		List<Project> projects = projectRepository.findAll();
		List<ProjectDTO> listProjectDTO = projectMapper.listOfProjectToDTO(projects);
		return listProjectDTO;
	}

	public ResponseEntity<String> createProject(CreateProjectModel receivedModel) {

		Project project = new Project();

		log.info("User Service : " + receivedModel.toString());
		project.setProjectDescription(receivedModel.getProjectDescription());
		project.setProjectName(receivedModel.getProjectName());
		//if(receivedModel.getTickets()!=null) project.setTickets(receivedModel.getTickets());

		Project savedProject = projectRepository.save(project);
		if (projectRepository.findById(savedProject.getId()).isPresent())
			return ResponseEntity.ok("Project Created Successfully");
		else
			return ResponseEntity.unprocessableEntity().body("Failed Creating Project as Specified");

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