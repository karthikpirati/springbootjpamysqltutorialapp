package com.springboot.SpringBootProject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserRequestDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String password;
	private String reenterpasssowrd;
	private Date dob;
	private byte gender;

}
