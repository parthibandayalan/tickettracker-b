package com.tickettracker.tickettrackerb.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tickettracker.tickettrackerb.repositories.UserJpaRepository;
import com.tickettracker.tickettrackerb.entity.MyUserDetails;
import com.tickettracker.tickettrackerb.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserJpaRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not Found" + username));

		return user.map(MyUserDetails::new).get();

	}

}