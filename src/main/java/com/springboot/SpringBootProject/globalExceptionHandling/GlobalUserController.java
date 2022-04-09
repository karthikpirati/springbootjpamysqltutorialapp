package com.springboot.SpringBootProject.globalExceptionHandling;

import java.util.*;

import com.springboot.SpringBootProject.authentication.service.impl.UserServiceIMpl;
import com.springboot.SpringBootProject.dto.TestDto;
import com.springboot.SpringBootProject.dto.UserResDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.dto.UserRequestDTO;
import com.springboot.SpringBootProject.dto.UserResponseDTO;
import com.springboot.SpringBootProject.models.User;
import com.springboot.SpringBootProject.repository.UserRepository;

@RequestMapping(value="/sm1")
@RestController
@Slf4j
public class GlobalUserController {
	
//	Logger logger=LoggerFactory.getLogger(UserController.class);
//


	@Autowired
	private UserRepository userRepository;

	@Qualifier
	private UserServiceIMpl userServiceIMpl;

	@Autowired
	public GlobalUserController(UserServiceIMpl userServiceIMpl){
		this.userServiceIMpl = userServiceIMpl;
	}

	
	@PostMapping(value="/register")
	public AppGenericResponse save(@RequestBody UserRequestDTO dto) throws InvalidDataException {
		log.info("UserController >> save() >> starts");

		//we have

		TestDto testDto = new TestDto();
		testDto.setMessage("Password and confirm pass should be same");

		AppGenericResponse a = null;

		if(!dto.getPassword().equals(dto.getReenterpasssowrd())){
//			return new ResponseEntity<>("Password and reenter pass slkdsklvjs",HttpStatus.BAD_REQUEST);
//
////			a= new AppGenericResponse<>(HttpStatus.BAD_REQUEST);
////			a.setStatus(HttpStatus.BAD_REQUEST.value());
////			a.setMessage("Password and Confirm password are incorrect");
//			return a;

			throw new InvalidDataException();
		}

		int i = 1/0;

//		try{
//			String s = "abc";
//			Integer.parseInt(s);
//		}catch(ArithmeticException e){
//			logger.error("art exp",e);
//		}catch(Exception e){
//			logger.error("exp",e);
//		}





		//userServiceIMpl.save(dto)!=null


		if(Objects.isNull(userServiceIMpl.save(dto))){
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			a.setStatus(HttpStatus.NO_CONTENT.value());

		}

//		if(Objects.isNull(userServiceIMpl.save(dto))){
////			return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
//			a.setMessage("some meaning error message to user");
//			a.setStatus(HttpStatus.OK);
//		}

//		return ResponseEntity.of(Optional.of(userServiceIMpl.save(dto)));

		a.setData(userServiceIMpl.save(dto));
		a.setStatus(HttpStatus.OK.value());

		return a;
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		log.info("UserController >> save() >> starts");
		List<UserResponseDTO> response=new ArrayList<UserResponseDTO>();
		List<Integer> failedIds=new ArrayList<Integer>();
		List<User> users=userRepository.findAll();


		for(int i=0;i<users.size();i++) {
			try {

			User user=users.get(i);
			if(i==2) {
				int val=i/0;
			}
			UserResponseDTO dto=new UserResponseDTO();
//			dto.setUserId(user.getUserId());
//			dto.setUsername(user.getUsername());
			response.add(dto);
			}catch (Exception e) {
				failedIds.add(users.get(i).getUserId());
				log.error("error while convert user to unserdto "+users.get(i).getUserId(), e);
			}
		}


		UserResDTO userResDTO = new UserResDTO();
		userResDTO.setResponse(response);
		Map<String, List<Integer>> params = new HashMap<>();
		params.put("failedIds", failedIds);
		userResDTO.setParams(params);

		return new ResponseEntity<>(userResDTO, HttpStatus.OK);
	}
	
	

}
