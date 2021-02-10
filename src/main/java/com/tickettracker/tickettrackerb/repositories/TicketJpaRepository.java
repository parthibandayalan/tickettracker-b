package com.tickettracker.tickettrackerb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tickettracker.tickettrackerb.entity.Ticket;
import com.tickettracker.tickettrackerb.entity.User;

@Repository
public interface TicketJpaRepository extends JpaRepository<Ticket, Long> {
//	Optional<User> findById(Long id);
//	boolean existsByUsername(String username);
	List<Ticket> findByCreatedUser_Id(Long Id);
	List<Ticket> findByAssignedUser_Id(Long Id);
	
}
