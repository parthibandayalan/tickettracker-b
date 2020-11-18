package com.tickettracker.tickettrackerb.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {
	
	private String id;
	private String projectName;
	private String projectDescription;
	private UserDTO projectManager;
	private List<TicketDTO> tickets;
	private List<UserDTO> contributors;
}
