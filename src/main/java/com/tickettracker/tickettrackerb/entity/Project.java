package com.tickettracker.tickettrackerb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@JsonIdentityInfo(scope=Project.class,generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Entity
@Table(name = "t_project")
@Data
public class Project {
	
	@Id
	@GenericGenerator(name = "sequence_project_id", strategy = "com.tickettracker.tickettrackerb.entity.ProjectIdGenerator")
	@GeneratedValue(generator = "sequence_project_id")	
	private String id;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)	
//	private String id;

	private String projectName;

	private String projectDescription;
	
	//@JsonIdentityReference(alwaysAsId = true)	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ticket> tickets;

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectDescription=" + projectDescription + "]";
	}
	
}
