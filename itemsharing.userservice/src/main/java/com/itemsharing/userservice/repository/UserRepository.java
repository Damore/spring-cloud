package com.itemsharing.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.itemsharing.userservice.model.Usuario;


public interface UserRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);
	

}
