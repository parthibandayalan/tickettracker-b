package com.tickettracker.tickettrackerb.dto;


import java.util.List;

import com.tickettracker.tickettrackerb.entity.Severity;
import com.tickettracker.tickettrackerb.entity.Status;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {

	private Long id;
	private String title;
	private String description;
	private Severity severity;
	private Status status;
	private UserDTO createdUser;
	private UserDTO assignedUser;
	private ProjectDTO project;
	private List<CommentDTO> comments;

}