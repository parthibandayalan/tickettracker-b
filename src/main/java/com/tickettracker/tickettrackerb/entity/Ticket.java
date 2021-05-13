package com.tickettracker.tickettrackerb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private Long id;

	private String title;

	private String description;

	@Enumerated
	@Column(columnDefinition = "smallint")
	private Severity severity;

	@Enumerated
	@Column(columnDefinition = "smallint")
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	private User createdUser;

	@ManyToOne(fetch = FetchType.LAZY)
	private User assignedUser;

	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", severity=" + severity
				+ ", status=" + status + ", createdUser=" + createdUser + ", assignedUser=" + assignedUser + "]";
	}

}
