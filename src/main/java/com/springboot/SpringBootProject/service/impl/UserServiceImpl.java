package com.springboot.SpringBootProject.service.impl;

import com.springboot.SpringBootProject.dto.UserRequestDTO;
import com.springboot.SpringBootProject.dto.UserResponseDTO;
import com.springboot.SpringBootProject.globalExceptionHandling.DuplicateEntryException;
import com.springboot.SpringBootProject.globalExceptionHandling.InvalidDataException;
import com.springboot.SpringBootProject.models.User;
import com.springboot.SpringBootProject.repository.UserRepository;
import com.springboot.SpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(rollbackFor = { InvalidDataException.class })
    public UserResponseDTO save(UserRequestDTO userRequestDTO) throws InvalidDataException, DuplicateEntryException {
        User user = new User();
        prepareUserEntity(userRequestDTO, user);
        try{
            User userSaved = userRepository.save(user);
            return prepareUserResponseDTO(userSaved);
        }catch (Exception sqlIntegrityConstraintViolationException){
            throw new DuplicateEntryException(sqlIntegrityConstraintViolationException.getMessage());
        }

    }


    @Override
    public UserResponseDTO update(UserRequestDTO userRequestDTO) {
        Optional<User> optionalUser = userRepository.findById(userRequestDTO.getId());
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
            prepareUserEntity(userRequestDTO,user);
        }
        User userSaved = userRepository.save(user);
        return prepareUserResponseDTO(userSaved);
    }

//    @Transactional
    public User prepareUserEntity(UserRequestDTO userRequestDTO, User user){
//        int i =1/0;
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setPassword(userRequestDTO.getPassword());
        user.setEmail(userRequestDTO.getEmail());
        user.setMobileNo(userRequestDTO.getMobileNo());
        user.setDob(userRequestDTO.getDob());
        user.setGender(userRequestDTO.getGender());
        return user;
    }


    private UserResponseDTO prepareUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getUserId());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setMobileNo(user.getMobileNo());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setDob(user.getDob());
        userResponseDTO.setGender(user.getGender());
        return userResponseDTO;
    }


    @Override
    public UserResponseDTO findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }

        return prepareUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO findByMobileNo(String moibileNo) {
        return null;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> userList =  userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
//        for(User user : userList){
//
//        }
        userList.forEach(user->{
                UserResponseDTO userResponseDTO  = prepareUserResponseDTO(user);
            userResponseDTOList.add(userResponseDTO);
        });

        return userResponseDTOList;
    }

    @Override
    public List<UserResponseDTO> findByEmailContains(String email) {
        List<User> userList =  userRepository.findByEmailContains(email);
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        userList.forEach(user->{
            UserResponseDTO userResponseDTO  = prepareUserResponseDTO(user);
            userResponseDTOList.add(userResponseDTO);
        });

        return userResponseDTOList;
    }
}
