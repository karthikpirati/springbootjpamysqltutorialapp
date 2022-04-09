package com.springboot.SpringBootProject.authentication.service.impl;

import com.springboot.SpringBootProject.dto.UserRequestDTO;
import com.springboot.SpringBootProject.dto.UserResponseDTO;
import com.springboot.SpringBootProject.globalExceptionHandling.InvalidDataException;
import com.springboot.SpringBootProject.models.User;
import com.springboot.SpringBootProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceIMpl {

	@Autowired

	private UserRepository userrepo;
	
	public UserResponseDTO save(UserRequestDTO userRequestDTO) throws InvalidDataException{
		log.info("entered >> UserServiceIMpl >> save");
		User user=new User();
		// service layer logic



		if(userRequestDTO.getPassword().equals(userRequestDTO.getReenterpasssowrd())) {
//			user.setPassword(userRequestDTO.getPassword())
			throw new InvalidDataException();
		}else {
//			throw new InvalidDataException("Passwords did not match");
		}



		user.setFirstName(userRequestDTO.getFirstName());
		user.setLastName(userRequestDTO.getLastName());
//		user.setUsername(userRequestDTO.getFirstName()+userRequestDTO.getLastName());

		userrepo.save(user);

		log.info("saved successfully",(user!=null) ? user.getUserId() : "empty");
		UserResponseDTO userResponseDTO=new UserResponseDTO();
//		userResponseDTO.setUserId(user.getUserId());
//		userResponseDTO.setUsername(user.getUsername());

		return userResponseDTO;

//		return "";



	}

}
