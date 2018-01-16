package com.itemsharing.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itemsharing.userservice.model.Usuario;
import com.itemsharing.userservice.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/{username}")
	public Usuario getUserByUsername(@PathVariable String username) {
		logger.debug("Entering the user-service-controller");
		
		return userService.getUserByUsername(username);
	}
	
	@PostMapping
	public Usuario createUser(@RequestBody Usuario user) {
		return userService.createUser(user);
	}
	
}
