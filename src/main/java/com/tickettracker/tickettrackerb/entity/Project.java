package com.tickettracker.tickettrackerb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "t_project")
@Data
public class Project {
	
	public Project() {
		super();
	}
	
	@Id
	@GenericGenerator(name = "sequence_project_id", strategy = "com.tickettracker.tickettrackerb.entity.ProjectIdGenerator")
	@GeneratedValue(generator = "sequence_project_id")	
	private String id;

	private String projectName;

	private String projectDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User projectManager;
	
		
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ticket> tickets;
	
	@ManyToMany
	private List<User> contributors;

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectDescription=" + projectDescription + "]";
	}
	
}
