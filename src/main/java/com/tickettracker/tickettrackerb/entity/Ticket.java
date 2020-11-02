package com.tickettracker.tickettrackerb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "t_ticket")
@Data
public class Ticket {

	public Ticket() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	private String title;

	private String description;

	@Enumerated
	@Column(columnDefinition = "smallint")
	private Severity severity;

	@Enumerated
	@Column(columnDefinition = "smallint")
	private Status status;

	// @JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdUser;

	// @JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private User assignedUser;

	// @JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", severity=" + severity
				+ ", status=" + status + ", createdUser=" + createdUser + ", assignedUser=" + assignedUser + "]";
	}

}
