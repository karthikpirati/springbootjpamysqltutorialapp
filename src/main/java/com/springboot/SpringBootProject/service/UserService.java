package com.springboot.SpringBootProject.service;

import com.springboot.SpringBootProject.dto.UserRequestDTO;
import com.springboot.SpringBootProject.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    public UserResponseDTO save(UserRequestDTO userRequestDTO) throws Exception;
    public UserResponseDTO update(UserRequestDTO userRequestDTO);
    public UserResponseDTO findByEmail(String email);
    public UserResponseDTO findByMobileNo(String moibileNo);
    public List<UserResponseDTO> findAll();
    public List<UserResponseDTO>  findByEmailContains(String name);
}
