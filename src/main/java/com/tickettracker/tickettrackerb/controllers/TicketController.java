package com.tickettracker.tickettrackerb.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tickettracker.tickettrackerb.dto.TicketDTO;
import com.tickettracker.tickettrackerb.entity.User;
import com.tickettracker.tickettrackerb.model.CreateTicketModel;
import com.tickettracker.tickettrackerb.service.TicketService;
import com.tickettracker.tickettrackerb.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TicketController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	TicketService ticketService;
	@Autowired
	UserService userService;

	@GetMapping("/tickets")
	List<TicketDTO> getTicket() {
		logger.info("Check Point for Debug");
		return ticketService.findAll();
	}
	
	@GetMapping("/ticket/{id}")
	ResponseEntity<Object> getTicketById(@PathVariable Long id) {
		logger.info("Check Point for Debug");
		return ticketService.findTicketById(id);
	}

	@GetMapping("ticket/assigned/{username}")
	ResponseEntity<Object> getAssignedTicket(@PathVariable String username){
		Optional<User> user = userService.findByUsername(username);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(ticketService.findTicketAsContributor(user.get().getId()));
		} else {
			return ResponseEntity.unprocessableEntity().body("Username doesnt exist");
		}
		
	}
	
	/*@GetMapping("ticket/contributor/{id}")
	ResponseEntity<Object> getTicketAsContributor(@PathVariable Long id){
		logger.info(payload.toString());
		Long id = Long.parseLong(payload.get("id").toString());
		return ResponseEntity.ok(ticketService.findTicketAsContributor(id)); 
	}*/
	
	@GetMapping("ticket/creator/{username}")
	ResponseEntity<Object> getCreatedTicket(@PathVariable String username){
		Optional<User> user = userService.findByUsername(username);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(ticketService.findTicketAsCreator(user.get().getId()));
		} else {
			return ResponseEntity.unprocessableEntity().body("Username doesnt exist");
		}
		
	}
	
	/*@GetMapping("ticket/creator/{id}")
	ResponseEntity<Object> getTicketAsCreator(@PathVariable Long id){
//		logger.info(payload.toString());
//		Long id = Long.parseLong(payload.get("id").toString());
		return ResponseEntity.ok(ticketService.findTicketAsCreator(id)); 
	}*/

	@PostMapping("/ticket/create")
	ResponseEntity<String> addTicket(@RequestBody @Valid CreateTicketModel createModel) throws Exception {
		return ticketService.createTicket(createModel);
	}
	
	@PutMapping("/update/ticket")
	ResponseEntity<String> updateTicket(@RequestBody Map<String,Object> payload){
		logger.info(payload.toString());
		String column = payload.get("column").toString();
		String value = payload.get("value").toString();
		String id = payload.get("id").toString();
		return ticketService.updateTicket(column, value, id);
	}

	@DeleteMapping("/ticket/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		return ticketService.deleteTicket(id);
	}

}