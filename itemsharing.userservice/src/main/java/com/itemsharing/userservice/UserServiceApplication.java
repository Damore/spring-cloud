package com.itemsharing.userservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.itemsharing.userservice.model.Role;
import com.itemsharing.userservice.model.Usuario;
import com.itemsharing.userservice.model.UsuarioRole;
import com.itemsharing.userservice.service.UserService;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setFirstName("John");
		usuario.setLastName("Adams");
		usuario.setUsername("jadams");
		usuario.setPassword("password");
		usuario.setEmail("jadams@gmail.com");
		
		Set<UsuarioRole> userRoles = new HashSet<>();
		Role role = new Role();
		role.setId(1L);
		role.setName("ROLE_USER");
		userRoles.add(new UsuarioRole(usuario, role));
		
		userService.createUser(usuario);
		
		
	}

}
