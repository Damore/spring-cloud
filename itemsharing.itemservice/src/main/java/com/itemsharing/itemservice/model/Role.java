package com.itemsharing.itemservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UsuarioRole> userRoles = new HashSet<>();
	
	public Role() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UsuarioRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UsuarioRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	

}
