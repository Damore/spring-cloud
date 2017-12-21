package com.itemsharing.itemservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.itemsharing.itemservice.model.Usuario;


public interface UserRepository extends CrudRepository<Usuario, Long> {
	
	Usuario findByUsername(String username);
	

}
