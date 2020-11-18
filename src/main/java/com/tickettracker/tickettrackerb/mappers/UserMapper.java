package com.tickettracker.tickettrackerb.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.tickettracker.tickettrackerb.dto.UserDTO;
import com.tickettracker.tickettrackerb.entity.User;

@Mapper(componentModel="spring",uses = {ProjectMapper.class})
public interface UserMapper {
    
	@Named("ListofUserDetails")
	@IterableMapping( qualifiedByName = "UserDetails")
	List<UserDTO> listOfUserEntitytoUserDTO(List<User> userList);
	
	@Named("UserDetails")    
    UserDTO toUserDTO(User projectManager);
	
	/*
	
	@Named("ListOfTicketsIgnoreProjects")    
    @IterableMapping( qualifiedByName = "TicketIgnoreProject")
    List<TicketDTO> listOfTicketToDTO(List<Ticket> tickets);
    
    @Named("TicketIgnoreProject")
    @Mappings({@Mapping(target = "project", ignore = true)})
    TicketDTO toDTOIgnoreProject(Ticket ticket);
    
    @Mappings({@Mapping(target = "project", qualifiedByName = "ProjectWithNoTickets")})
    TicketDTO toDTOWithProject(Ticket ticket);    */

    
}