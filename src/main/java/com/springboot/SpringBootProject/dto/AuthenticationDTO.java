package com.springboot.SpringBootProject.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String email;
    private String userName;
    private String password;
}
