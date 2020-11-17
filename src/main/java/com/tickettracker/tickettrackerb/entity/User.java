package com.tickettracker.tickettrackerb.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;


import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

	@Enumerated
	@Column(columnDefinition = "smallint")
	private Roles role;

	@Column(nullable = false, unique = true)
	private String username;

	private String password;

	@PastOrPresent
	private LocalDate createdOn;

	@Column(columnDefinition = "boolean default false")
	private Boolean approved;

}
