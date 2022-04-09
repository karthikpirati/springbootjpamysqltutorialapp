package com.springboot.SpringBootProject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private Date dob;
	private byte gender;

}
