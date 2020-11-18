package com.tickettracker.tickettrackerb.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.tickettracker.tickettrackerb.dto.TicketDTO;
import com.tickettracker.tickettrackerb.entity.Ticket;

@Mapper(componentModel="spring",uses = {ProjectMapper.class,UserMapper.class})
public interface TicketMapper {
    
	//TicketMapper MAPPER = Mappers.getMapper( TicketMapper.class );
	
	@Named("ListOfTicketsIgnoreProjects")    
    @IterableMapping( qualifiedByName = "TicketIgnoreProject")
    List<TicketDTO> listOfTicketToDTO(List<Ticket> tickets);
    
    @Named("TicketIgnoreProject")
    @Mappings({@Mapping(target = "project", ignore = true)})
    TicketDTO toDTOIgnoreProject(Ticket ticket);
    
    @Mappings({
    	@Mapping(target = "project", qualifiedByName = "ProjectWithNoTickets"),
    	@Mapping(target = "createdUser", qualifiedByName = "UserDetails"),
    	@Mapping(target = "assignedUser", qualifiedByName = "UserDetails")
    	})
    TicketDTO toDTOWithProject(Ticket ticket);    

    
}