package com.tickettracker.tickettrackerb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tickettracker.tickettrackerb.entity.Roles;
import com.tickettracker.tickettrackerb.entity.Ticket;
import com.tickettracker.tickettrackerb.entity.User;
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
	

	public List<User> findAll() {
		User user = userRepository.findAll().get(0);
		log.info("User Service : " + user.toString());
		return userRepository.findAll();
	}

	public ResponseEntity<String> createUser(CreateUserModel receivedUserModel) {

		if (!userRepository.existsByUsername(receivedUserModel.getUsername())) {
			User user = new User();
			user.setUsername(receivedUserModel.getUsername());
			user.setPassword(receivedUserModel.getPassword());
			user.setApproved(receivedUserModel.getApproved());
			user.setRole(Roles.valueOf(receivedUserModel.getRole()));
			User savedUser = userRepository.save(user);
			if (userRepository.findById(savedUser.getId()).isPresent())
				return ResponseEntity.ok("User Created Successfully");
			else
				return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
		} else {
			return ResponseEntity.badRequest().body("User Name not available");
		}

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
