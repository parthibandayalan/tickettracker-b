package com.tickettracker.tickettrackerb.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.tickettracker.tickettrackerb.dto.CommentDTO;
import com.tickettracker.tickettrackerb.dto.TicketDTO;
import com.tickettracker.tickettrackerb.entity.Comment;
import com.tickettracker.tickettrackerb.entity.Ticket;

@Mapper(componentModel="spring",uses = {TicketMapper.class,UserMapper.class})
public interface CommentMapper {

	@Named("ListOfComments")    
    @IterableMapping( qualifiedByName = "CommentWithUsers")
    List<CommentDTO> listOfCommentToDTO(List<Comment> comments);
	
	@Named("CommentWithUsers")
	@Mappings({
		@Mapping(target = "author",qualifiedByName="UserDetails")
	})
	CommentDTO commentToDTO(Comment comment);
	
}
