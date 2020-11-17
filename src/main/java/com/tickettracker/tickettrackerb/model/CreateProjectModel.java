package com.tickettracker.tickettrackerb.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateProjectModel {

	@Size(min = 6, message = "Title needs to be minimum length of 6")
	@Size(max = 50, message = "Title can be of a maximum length of 100")
	@NotBlank(message = "Title cannot be blank")
	@NotNull(message = "Title cannot be null")
	private String projectName;

	@Size(min = 10, message = "Description needs to be minimum length of 10")
	@Size(max = 100, message = "Description can be of a maximum length of 500")
	@NotBlank(message = "Description cannot be blank")
	@NotNull(message = "Description cannot be null")
	private String projectDescription;
	//private List<Ticket> tickets;
	
	private String projectManager;

}