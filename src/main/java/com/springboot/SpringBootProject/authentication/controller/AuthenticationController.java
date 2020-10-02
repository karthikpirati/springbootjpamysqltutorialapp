package com.springboot.SpringBootProject.authentication.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.authentication.dto.AuthUserResponseDTO;
import com.springboot.SpringBootProject.authentication.model.AuthUser;
import com.springboot.SpringBootProject.authentication.service.AuthService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {
	
	Logger logger=LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthService userService;
	
	@PostMapping
	public ResponseEntity<AuthUserResponseDTO> register(@RequestBody AuthUser user) {
		AuthUserResponseDTO responseDTO = null;
		try {
			AuthUser authUser=userService.register(user);
			responseDTO = prepareResponse(authUser);
			return new ResponseEntity<AuthUserResponseDTO>(responseDTO, HttpStatus.OK);
		}catch (Exception e) {
			logger.error("Eror occured while storing user" +e.getMessage(), user);
			ResponseEntity r = new ResponseEntity<AuthUserResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			return r;
		}
	}
	
	@GetMapping
	public ResponseEntity<List<AuthUserResponseDTO>> getAllUsers(){
		List<AuthUserResponseDTO> responseDTOList = new ArrayList<AuthUserResponseDTO>();
		try {
			List<AuthUser> authUserList= userService.getAllUsers();
			for(AuthUser user : authUserList) {
				try {
					responseDTOList.add(prepareResponse(user));
				}catch (Exception e) {
					logger.error("Error occured while converting user to dto", e, user);
				}
			}
			logger.info("User to Response DTO conversion completed successfully");
			return new ResponseEntity<List<AuthUserResponseDTO>>(responseDTOList, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<AuthUserResponseDTO>>(responseDTOList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@PutMapping
	public ResponseEntity<AuthUserResponseDTO>  update(@RequestBody AuthUser user) {
		AuthUserResponseDTO responseDTO = null;
		try {
			AuthUser authUser=userService.update(user);
			responseDTO = prepareResponse(authUser);
			return new ResponseEntity<AuthUserResponseDTO>(responseDTO, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<AuthUserResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/{email}")
	public void delete(@PathVariable String email) {
		 userService.delete(email);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<AuthUserResponseDTO> findByEmail(@PathVariable String email) {
		AuthUserResponseDTO responseDTO = null;
		try {
			AuthUser authUser=userService.findByEmail(email);
			responseDTO = prepareResponse(authUser);
			return new ResponseEntity<AuthUserResponseDTO>(responseDTO, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<AuthUserResponseDTO>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	private AuthUserResponseDTO prepareResponse(AuthUser user){
		AuthUserResponseDTO resonseDTO = new AuthUserResponseDTO();
		resonseDTO.setFirstName(user.getFirstName());
		resonseDTO.setLastName(user.getLastName());
		resonseDTO.setDob(user.getDob());
		resonseDTO.setEmail(user.getEmail());
		resonseDTO.setRegisteredDate(user.getRegisteredDate());
		return resonseDTO;
	}

}
