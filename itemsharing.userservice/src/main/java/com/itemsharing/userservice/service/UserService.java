package com.itemsharing.userservice.service;

import com.itemsharing.userservice.model.Usuario;

public interface UserService {
	
	Usuario createUser(Usuario user);
	
	Usuario getUserByUsername(String username);

}
