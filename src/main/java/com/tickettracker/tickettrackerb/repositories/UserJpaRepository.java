package com.tickettracker.tickettrackerb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tickettracker.tickettrackerb.entity.Roles;
import com.tickettracker.tickettrackerb.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);
	Optional<User> findByUsername(String username);	
	boolean existsByUsername(String username);
	List<User> findAllByApproved(Boolean approved);
	List<User> findAllByIdNotInAndApprovedAndRole(List<Long> userIds,Boolean approved,Roles role); 
}