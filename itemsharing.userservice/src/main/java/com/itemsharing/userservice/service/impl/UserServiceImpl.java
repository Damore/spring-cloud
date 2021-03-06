package com.itemsharing.userservice.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemsharing.userservice.model.Role;
import com.itemsharing.userservice.model.UsuarioRole;
import com.itemsharing.userservice.model.Usuario;
import com.itemsharing.userservice.repository.UserRepository;
import com.itemsharing.userservice.service.UserService;
import com.itemsharing.userservice.utility.SecurityUtility;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Usuario createUser(Usuario user) {
		Usuario localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exists. Nothing will be done", user.getUsername());
		} else {
			Set<com.itemsharing.userservice.model.UsuarioRole> userRoles = new HashSet<>();
			Role localRole = new Role();
			localRole.setId(1L);
			userRoles.add(new UsuarioRole(user, localRole));
			user.getUserRoles().addAll(userRoles);
			
			Date today = new Date();
			user.setJoinDate(today);
			
			String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword);
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}

	@Override
	public Usuario getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	
	
}
