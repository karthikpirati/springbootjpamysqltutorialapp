package com.springboot.SpringBootProject.globalExceptionHandling;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.dto.UserRequestDTO;
import com.springboot.SpringBootProject.dto.UserResponseDTO;
import com.springboot.SpringBootProject.models.User;
import com.springboot.SpringBootProject.repository.UserRepository;

@RequestMapping(value="/users")
@RestController
public class UserController {
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userrepo;
	
	@PostMapping(value="/register")
	public UserResponseDTO save(@RequestBody UserRequestDTO dto) throws InvalidDataException {
		logger.info("UserController >> save() >> starts");
		User user=new User();
		UserResponseDTO u=null;
		// service layer logic
		
		
		
		if(dto.getPassword().equals(dto.getReenterpasssowrd())) {
			user.setPassword(dto.getPassword());
		}else {
			throw new InvalidDataException("Passwords did not match");
		}
		
		
		
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setUsername(dto.getFirstName()+dto.getLastName());
		
		userrepo.save(user);
		
		u=new UserResponseDTO();
		u.setUserId(user.getUserId());
		u.setUsername(user.getUsername());
		
		
		return u;
		
	}
	
	@GetMapping
	public List<UserResponseDTO> getAllUsers() {
		logger.info("UserController >> save() >> starts");
		List<UserResponseDTO> response=new ArrayList<UserResponseDTO>();
		List<User> users=userrepo.findAll();
		
		
		for(int i=0;i<users.size();i++) {
			try {
			
			User user=users.get(i);
			if(i==2) {
				int val=i/0;
			}
			UserResponseDTO dto=new UserResponseDTO();
			dto.setUserId(user.getUserId());
			dto.setUsername(user.getUsername());
			response.add(dto);
			}catch (Exception e) {
				logger.error("problem while converting user to userresponse dto",e);
			}
		}
		
		
		return response;
	}
	
	

}
