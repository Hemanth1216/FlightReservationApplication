package com.hemanth.flightreservation.entities;

import java.util.List;

//import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Role extends AbstractClass { //implements GrantedAuthority

	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> users; //a role can be assigned to many users (many to many relationship)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

//	@Override
//	public String getAuthority() {
//		return name;
//	}
}
