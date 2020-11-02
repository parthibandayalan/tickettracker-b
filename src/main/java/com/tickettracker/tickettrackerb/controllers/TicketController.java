package com.tickettracker.tickettrackerb.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tickettracker.tickettrackerb.dto.TicketDTO;
import com.tickettracker.tickettrackerb.entity.Ticket;
import com.tickettracker.tickettrackerb.model.CreateTicketModel;
import com.tickettracker.tickettrackerb.service.TicketService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TicketController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	TicketService ticketService;

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

	@PostMapping("/ticket")
	ResponseEntity<String> addTicket(@RequestBody @Valid CreateTicketModel createModel) throws Exception {
		return ticketService.createTicket(createModel);

	}

	@DeleteMapping("/ticket/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		return ticketService.deleteTicket(id);
	}

}