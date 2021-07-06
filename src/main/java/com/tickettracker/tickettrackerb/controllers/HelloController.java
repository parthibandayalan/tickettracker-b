package com.tickettracker.tickettrackerb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	Environment env;
	
//	@Value("${test.url}")
//	String url;
	
	@GetMapping("/getenv")
	ResponseEntity<String> getEnv() {
//		logger.info(url);
		return ResponseEntity.ok().body(env.getProperty("spring.datasource.url") + " " + env.getProperty("spring.datasource.username") + " " + env.getProperty("spring.datasource.password"));
	}
	
}
