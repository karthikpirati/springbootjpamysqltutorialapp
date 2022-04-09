package com.springboot.SpringBootProject.controller;

import com.springboot.SpringBootProject.dto.UserRequestDTO;
import com.springboot.SpringBootProject.dto.UserResponseDTO;
import com.springboot.SpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDTO save(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        return userService.save(userRequestDTO);
    }

    @PutMapping
    public UserResponseDTO update(@RequestBody UserRequestDTO userRequestDTO){
        return userService.update(userRequestDTO);
    }

    @GetMapping
    public List<UserResponseDTO> getAll(){
//        int i = 1/0;
        return userService.findAll();
    }

    @GetMapping("/{email}")
    public UserResponseDTO findByEmail(@PathVariable("email") String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/like/{name}")
    public List<UserResponseDTO> findByEmailContains(@PathVariable("name") String name) throws InterruptedException {
        List<UserResponseDTO>  responseDTOS = userService.findByEmailContains(name);
        Thread.sleep(1000);
        return responseDTOS;
    }
}
