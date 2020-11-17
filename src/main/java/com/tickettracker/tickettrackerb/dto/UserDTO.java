package com.tickettracker.tickettrackerb.dto;

import java.time.LocalDate;

import com.tickettracker.tickettrackerb.entity.Roles;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	private Roles role;
	private String username;	
	private Boolean approved;
	private LocalDate createdOn;

}
