package com.tickettracker.tickettrackerb.controllers;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/user/unapproved")
	ResponseEntity<Object> getUser(){
		return userService.findUnApprovedUser();
	}
	
	@PutMapping("/check/user")
	ResponseEntity<String> checkUserExist(@RequestBody Map<String,Object> payload){
		String username = payload.get("username").toString();
		return userService.checkUserExist(username);
	}
	
	@PutMapping("/user/approve")
	ResponseEntity<String> approveUsers(@RequestBody Map<String,List<Integer>> payload){
		//String username = payload.get("username").toString();
		logger.info(payload.get("users").toString());
		List<Integer> userIds = payload.get("users"); 
		//List<Integer> userIds = Integer.parseInt(payload.get("users"));
		return userService.approveUsers(userIds);
	}

	@PostMapping("/user/create")
	ResponseEntity<String> addUser(@RequestBody @Valid CreateUserModel createUserModel) throws Exception {

		return userService.createUser(createUserModel);

	}
	
	@DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
