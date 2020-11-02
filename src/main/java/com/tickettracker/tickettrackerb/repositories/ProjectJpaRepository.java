package com.tickettracker.tickettrackerb.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tickettracker.tickettrackerb.entity.Project;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, String> {	
	
}