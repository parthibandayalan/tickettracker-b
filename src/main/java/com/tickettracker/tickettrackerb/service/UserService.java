package com.tickettracker.tickettrackerb.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tickettracker.tickettrackerb.dto.UserDTO;
import com.tickettracker.tickettrackerb.entity.Roles;
import com.tickettracker.tickettrackerb.entity.Severity;
import com.tickettracker.tickettrackerb.entity.Status;
import com.tickettracker.tickettrackerb.entity.Ticket;
import com.tickettracker.tickettrackerb.entity.User;
import com.tickettracker.tickettrackerb.mappers.UserMapper;
import com.tickettracker.tickettrackerb.model.CreateUserModel;
import com.tickettracker.tickettrackerb.repositories.TicketJpaRepository;
import com.tickettracker.tickettrackerb.repositories.UserJpaRepository;

@Service
public class UserService {

	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	TicketJpaRepository ticketRepository;
	@Autowired
	UserJpaRepository userRepository;
	@Autowired
	UserMapper userMapper;
	@Autowired
    private EntityManager em;
	
	public ResponseEntity<String> checkUserExist(String username){
		if (userRepository.existsByUsername(username)) {
			return ResponseEntity.ok("true");
		} else {
			return ResponseEntity.ok("false");
		}
		//return ResponseEntity.badRequest().body("Found");
	}

	public List<User> findAll() {
		User user = userRepository.findAll().get(0);
		log.info("User Service : " + user.toString());
		return userRepository.findAll();
	}
	
	public ResponseEntity<Object> findUnApprovedUser(){
		
		List<User> userList = userRepository.findAllByApproved(false);
		if(userList.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userMapper.listOfUserEntitytoUserDTO(userList));
		}
		
	}

	public ResponseEntity<String> createUser(CreateUserModel receivedUserModel) {

		if (!userRepository.existsByUsername(receivedUserModel.getUsername())) {
			User user = new User();
			user.setUsername(receivedUserModel.getUsername());
			user.setPassword(receivedUserModel.getPassword());
			user.setApproved(false);
			user.setRole(Roles.valueOf(receivedUserModel.getRole()));
			user.setCreatedOn(LocalDate.now());
			User savedUser = userRepository.save(user);
			
			if (userRepository.findById(savedUser.getId()).isPresent())
				return ResponseEntity.ok("User Created Successfully");
			else
				return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
		} else {
			return ResponseEntity.badRequest().body("User Name not available");
		}

	}
	
	@Transactional
	public ResponseEntity<String> approveUsers(List<Integer> listUserId){
		
		/////////////////////////
		for(Integer eachId : listUserId) {
			CriteriaBuilder cb = this.em.getCriteriaBuilder();
			
			CriteriaUpdate<User> update = cb.createCriteriaUpdate(User.class);
			
			Root e = update.from(User.class);
			
			update.set("approved", true);
			
			/*switch(attribute) {
				case "status":
					update.set(attribute, Status.valueOf(value));
					break;
				case "severity":
					update.set(attribute, Severity.valueOf(value));
					break;
				default:
					update.set(attribute, Status.valueOf(value));
			}*/
					
			update.where(cb.equal(e.get("id"), eachId ));
			this.em.createQuery(update).executeUpdate();
		}
		/////////////////////////
		
		return ResponseEntity.ok("Users approved");
	}
	
	public ResponseEntity<Object> deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
        	
        	User user = userRepository.findById(id).get();
        	
        	log.info("User Service : " + user.toString());
        	
//        	ticketRepository.findById(Long.valueOf("2"));
        	ticketRepository.findByCreatedUser_Id(user.getId());
			
			for(Ticket ticket : ticketRepository.findByCreatedUser_Id(user.getId())) {
				ticket.setCreatedUser(null);
				ticketRepository.save(ticket);
			}
			
			for(Ticket ticket : ticketRepository.findByAssignedUser_Id(user.getId())) {
				ticket.setAssignedUser(null);
				ticketRepository.save(ticket);
			}
        	
            userRepository.deleteById(id);
            if (userRepository.findById(id).isPresent())
                return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified User");
            else return ResponseEntity.ok().body("Successfully deleted the specified user");
        	
        } else return ResponseEntity.badRequest().body("Cannot find the user specified");
    }

}
