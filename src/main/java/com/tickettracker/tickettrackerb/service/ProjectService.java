package com.tickettracker.tickettrackerb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tickettracker.tickettrackerb.dto.ProjectDTO;
import com.tickettracker.tickettrackerb.entity.Project;
import com.tickettracker.tickettrackerb.entity.Roles;
import com.tickettracker.tickettrackerb.entity.User;
import com.tickettracker.tickettrackerb.mappers.ProjectMapper;
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
	@Autowired
    private EntityManager em;

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
	
	//return projects where the user is a project manager
	@Transactional
	public ResponseEntity<Object> findProjectsByUserId(String id){
		
		if(userRepository.findById(Long.parseLong(id)).isPresent()) {
			
			CriteriaBuilder cb = this.em.getCriteriaBuilder();
			AbstractQuery<Project> cq1=cb.createQuery(Project.class); 
			Root<Project> stud1=cq1.from(Project.class); 
			cq1.where(cb.equal(stud1.get("projectManager"), userRepository.findById(Long.parseLong(id)).get()) );
			
			CriteriaQuery<Project> select1 = ((CriteriaQuery<Project>) cq1).select(stud1);  
			TypedQuery<Project> tq1 = em.createQuery(select1);  
			List<Project> list1 = tq1.getResultList();
			
			List<ProjectDTO> listDTO = new ArrayList<ProjectDTO>();
			for(Project project:list1) {
				listDTO.add(projectMapper.projectWithTicketsNoProjects(project));				
			}		
			
			/*log.info("logging ");
			log.info(list1.toString());*/			
			return ResponseEntity.ok(listDTO);
			
		} else {
			return ResponseEntity.badRequest().body("Username doesnt exist");
		}
	}
	
	
	public ResponseEntity<String> removeContributors(String managerUsername,String projectId,List<Integer> userIds){
		if(projectRepository.findById(projectId).isPresent()) {
			Project project =projectRepository.findById(projectId).get();
			log.info("Project : "+project.toString());
			if(project.getProjectManager().getUsername().equals(managerUsername)) {
				for(Integer id : userIds) {
					Boolean removeSuccess = project.getContributors().removeIf(e -> e.getId().toString().equals(Long.toString(id)));
					log.info("removal  : "+removeSuccess.toString());
				}
				log.info("Project with contributors removed : "+project.getContributors().toString());
				projectRepository.save(project);
				return ResponseEntity.ok().body("Contributors Removed");
			} else {
				return ResponseEntity.badRequest().body("Invalid project manager");
			}
		} else {
			return ResponseEntity.badRequest().body("Project doesnt exist");
		}
	}
	
	public ResponseEntity<Object> getAvailableContributors(String managerUsername,String projectId){
		if(projectRepository.findById(projectId).isPresent()) {
			Project project = projectRepository.findById(projectId).get();
			if(project.getProjectManager().getUsername().equals(managerUsername)) {				
				List<Long> unAvailableUsers = project.getContributors().stream().map(u -> u.getId()).collect(Collectors.toList());
				List<User> availableUsers = userRepository.findAllByIdNotInAndApprovedAndRole(unAvailableUsers, true,Roles.Contributor);
				return ResponseEntity.ok(availableUsers);
			} else {
				return ResponseEntity.badRequest().body("Invalid project manager");
			}
		} else {
			return ResponseEntity.badRequest().body("Project doesnt exist");
		}				
	}

	public ResponseEntity<String> addContributors(String managerUsername, String projectId, List<Integer> userIds) {
		// TODO Auto-generated method stub
		
		if(projectRepository.findById(projectId).isPresent()) {
			Project project = projectRepository.findById(projectId).get();
			if(project.getProjectManager().getUsername().equals(managerUsername)) {
				List<User> contributors = project.getContributors();
				for(Integer id : userIds) {
					Optional<User> user = userRepository.findById(Long.valueOf(id.longValue()));
					if(user.isPresent()) {
						contributors.add(user.get());
					} else {
						return ResponseEntity.badRequest().body("Invalid Contributor Id");
					}
				}
				
				project.setContributors(contributors);
				log.info("Contributors : " + contributors.toString());
				projectRepository.save(project);
				return ResponseEntity.ok("Contributors Added");
				
			} else {
				return ResponseEntity.badRequest().body("Invalid project manager");
			}
		} else {
			return ResponseEntity.badRequest().body("Project doesnt exist");
		}		
	}
	
	

}