package com.tickettracker.tickettrackerb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tickettracker.tickettrackerb.entity.User;
import com.tickettracker.tickettrackerb.model.CreateUserModel;
import com.tickettracker.tickettrackerb.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping("/health")
	String getHealth() {
		return "Health OK";
	}

	@GetMapping("/users")
	List<User> getUsers() {
		logger.info("Check Point for Debug");
		return userService.findAll();
	}

	@PostMapping("/user")
	ResponseEntity<String> addUser(@RequestBody @Valid CreateUserModel createModel) throws Exception {

		return userService.createUser(createModel);

	}
	
	@DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
