package com.itemhsaring.authorizationserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.itemhsaring.authorizationserver.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long> {

	Usuario findByUsername(String username);
	
}
