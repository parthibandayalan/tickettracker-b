package com.tickettracker.tickettrackerb.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tickettracker.tickettrackerb.entity.Project;
import com.tickettracker.tickettrackerb.entity.Severity;
import com.tickettracker.tickettrackerb.entity.Status;
import com.tickettracker.tickettrackerb.entity.User;
import com.tickettracker.tickettrackerb.validators.ValidateEnum;

import lombok.Data;

@Data
public class CreateTicketModel {

	@Size(min = 6, message = "Title needs to be minimum length of 6")
	@Size(max = 100, message = "Title can be of a maximum length of 100")
	@NotBlank(message = "Title cannot be blank")
	@NotNull(message = "Title cannot be null")
	private String title;

	@Size(min = 10, message = "Description needs to be minimum length of 50")
	@Size(max = 500, message = "Description can be of a maximum length of 500")
	@NotBlank(message = "Description cannot be blank")
	@NotNull(message = "Description cannot be null")
	private String description;

	@NotNull(message = "Severity cannot be null")
	@ValidateEnum(targetClassType = Severity.class, message = "Available severity levels are Low,Medium,High")
	private String severity;

	@NotNull(message = "Status cannot be null")
	@ValidateEnum(targetClassType = Status.class, message = "Available status levels are New, Assigned, Open, Investigation, Resolved, Closed")
	private String status;
	
	private User assignedUser;
	
	private User createdUser;
	
	private String projectId;

}
