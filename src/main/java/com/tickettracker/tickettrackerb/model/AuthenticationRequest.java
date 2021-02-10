package com.tickettracker.tickettrackerb.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationRequest implements Serializable{
	String username;
	String password;
}
