package com.tickettracker.tickettrackerb.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.tickettracker.tickettrackerb.entity.Roles;
import com.tickettracker.tickettrackerb.validators.ValidateEnum;

import lombok.Data;

@Data
public class CreateUserModel {

	@NotNull(message = "Role cannot be null")
	@ValidateEnum(targetClassType = Roles.class, message = "Available roles are Admin, Manager, IndividualContributor. Please Select One")
	private String role;

	
	@Size(min=6 , message="Username needs to be minimum length of 6")
	@Size(max=20 , message="Username can be of a maximum length of 50")
	@NotBlank(message = "Username cannot be blank")
	@NotNull(message = "Username cannot be null")	
	private String username;

	@Size(min=8 , message="Password needs to be minimum length of 8")
	@Size(max=20 , message="Password can be of a maximum length of 50")
	@NotBlank(message = "Password cannot be blank")
	@NotNull(message = "Passwod cannot be null")	
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",message = "Password needs to have atleast one lower case alphabet, one upper case alphabet, one number and one special character")	
	private String password;	

}
