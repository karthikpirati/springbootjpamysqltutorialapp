package com.springboot.SpringBootProject.authentication.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.SpringBootProject.authentication.model.AuthUser;

public interface AuthService {
	
	public AuthUser register(AuthUser user);
	public AuthUser update(AuthUser user);
	public void delete(String email);
	public List<AuthUser> getAllUsers();
	public AuthUser findByEmail(String email);

}
