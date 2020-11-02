package com.tickettracker.tickettrackerb.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tickettracker.tickettrackerb.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long id);	
	boolean existsByUsername(String username);
}