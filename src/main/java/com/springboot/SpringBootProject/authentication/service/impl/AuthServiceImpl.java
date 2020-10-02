package com.springboot.SpringBootProject.authentication.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.authentication.controller.AuthenticationController;
import com.springboot.SpringBootProject.authentication.model.AuthUser;
import com.springboot.SpringBootProject.authentication.repository.AuthRepository;
import com.springboot.SpringBootProject.authentication.service.AuthService;


@Service
public class AuthServiceImpl implements AuthService{
	
	Logger logger=LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Autowired
	private AuthRepository userRepository;

	@Override
	public AuthUser register(AuthUser user) {
		//AuthUser authUser=userRepository.save(user);
		// return authUser;
		
		return userRepository.save(user);
	}

	@Override
	public List<AuthUser> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public AuthUser update(AuthUser user) {
		
		AuthUser authUser =userRepository.save(user);
		logger.info("User saved successfully",authUser);
		return authUser;
	}

	@Override
	public void delete(String email) {
		AuthUser authUser = findByEmail(email);
		logger.info("User found",authUser);
		if(authUser!=null) {
			userRepository.delete(authUser);
		}else{
			logger.info("User not found");
		}
	}

	@Override
	public AuthUser findByEmail(String email) {
		Optional<AuthUser> authUser=userRepository.findById(email);
		
		if(authUser.isPresent()) {
			return authUser.get();
		}
		
		return null;
	}

}
