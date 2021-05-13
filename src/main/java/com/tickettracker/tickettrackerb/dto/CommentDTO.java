package com.tickettracker.tickettrackerb.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	
	private Long id;	
	private UserDTO author;	
	private String message;
	private LocalDate createdOn;
	
}
