package com.tickettracker.tickettrackerb.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.tickettracker.tickettrackerb.dto.ProjectDTO;
import com.tickettracker.tickettrackerb.dto.TicketDTO;
import com.tickettracker.tickettrackerb.entity.Project;
import com.tickettracker.tickettrackerb.entity.Ticket;

@Mapper(uses = {TicketMapper.class})
public interface ProjectMapper {

	ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);
	
	@Named("ProjectWithTicketsNoProjects")
    @Mappings(
    		{@Mapping(target = "tickets", qualifiedByName = "ListOfTicketsIgnoreProjects")}
    )
	ProjectDTO projectWithTicketsNoProjects(Project project);
	
	@Named("ListOfProjectWithTicketsNoProjects")    
    @IterableMapping(qualifiedByName = "ProjectWithTicketsNoProjects")
    List<ProjectDTO> listOfProjectToDTO(List<Project> projects);
	
}
