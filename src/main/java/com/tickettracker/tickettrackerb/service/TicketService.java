package com.tickettracker.tickettrackerb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tickettracker.tickettrackerb.dto.TicketDTO;
import com.tickettracker.tickettrackerb.entity.Severity;
import com.tickettracker.tickettrackerb.entity.Status;
import com.tickettracker.tickettrackerb.entity.Ticket;
import com.tickettracker.tickettrackerb.mappers.TicketMapper;
import com.tickettracker.tickettrackerb.model.CreateTicketModel;
import com.tickettracker.tickettrackerb.repositories.ProjectJpaRepository;
import com.tickettracker.tickettrackerb.repositories.TicketJpaRepository;
import com.tickettracker.tickettrackerb.repositories.UserJpaRepository;

@Service
public class TicketService {

	Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	TicketJpaRepository ticketRepository;
	@Autowired
	UserJpaRepository userRepository;
	@Autowired
	ProjectJpaRepository projectRepository;
	@Autowired
	TicketMapper ticketMapper;

	public List<TicketDTO> findAll() {
//		User user = ticketRepository.findAll().get(0);
//		log.info("User Service : " + user.toString());
		List<Ticket> tickets = ticketRepository.findAll();
		List<TicketDTO> listTicketDTO = ticketMapper.listOfTicketToDTO(tickets);

//		for (Ticket t : ticketRepository.findAll()) {
//			listTicketDto.add(TicketMapper.INSTANCE.toDto(t));
//		}

		return listTicketDTO;
	}

	public ResponseEntity<Object> findTicketById(Long id) {
		

		if (!ticketRepository.findById(id).isPresent())
			return ResponseEntity.badRequest().body("Cannot find the ticket specified");
		else {
			//log.info("Ticket Service : " + foundTicket.toString());
			//TicketDTO tDto =
			Ticket foundTicket = ticketRepository.findById(id).get();
			return ResponseEntity.ok(ticketMapper.toDTOWithProject(foundTicket));			
		}

	}

	public ResponseEntity<String> createTicket(CreateTicketModel receivedTicketModel) {

		Ticket ticket = new Ticket();
		ticket.setDescription(receivedTicketModel.getDescription());
		ticket.setSeverity(Severity.valueOf(receivedTicketModel.getSeverity()));
		ticket.setStatus(Status.valueOf(receivedTicketModel.getStatus()));
		ticket.setTitle(receivedTicketModel.getTitle());
		ticket.setAssignedUser(receivedTicketModel.getAssignedUser());
		ticket.setCreatedUser(receivedTicketModel.getCreatedUser());

		if (!projectRepository.findById(receivedTicketModel.getProjectId()).isPresent()) {
			return ResponseEntity.unprocessableEntity().body("Project Not Found");
		}
		ticket.setProject(projectRepository.findById(receivedTicketModel.getProjectId()).get());
		log.info("Ticket to be saved : " + ticket.toString());
		Ticket savedTicket = ticketRepository.save(ticket);
		if (ticketRepository.findById(savedTicket.getId()).isPresent())
			return ResponseEntity.ok("Ticket Created Successfully");
		else
			return ResponseEntity.unprocessableEntity().body("Failed Creating Ticket as Specified");

	}

	public ResponseEntity<Object> deleteTicket(Long id) {
		if (ticketRepository.findById(id).isPresent()) {
			ticketRepository.deleteById(id);
			if (ticketRepository.findById(id).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified Ticket");
			else
				return ResponseEntity.ok().body("Successfully deleted the specified Ticket");
		} else
			return ResponseEntity.badRequest().body("Cannot find the ticket specified");
	}

}
