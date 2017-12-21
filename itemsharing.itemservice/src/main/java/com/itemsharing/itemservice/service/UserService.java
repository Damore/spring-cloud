package com.itemsharing.itemservice.service;

import com.itemsharing.itemservice.model.Usuario;

public interface UserService {
	
	Usuario findByUsername(String username);

}
