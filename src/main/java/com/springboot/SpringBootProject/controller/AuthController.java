package com.springboot.SpringBootProject.controller;

import com.springboot.SpringBootProject.dto.AuthenticationDTO;
import com.springboot.SpringBootProject.models.User;
import com.springboot.SpringBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.BooleanSupplier;

@CrossOrigin("*")
@RestController
@RequestMapping("/authenti")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<Boolean> authenticate(@RequestBody AuthenticationDTO authenticationDTO){
        //logic
        Optional<User> userOptional = this.userRepository.findByEmail(authenticationDTO.getEmail());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPassword().equals(authenticationDTO.getPassword())){
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
    }
}