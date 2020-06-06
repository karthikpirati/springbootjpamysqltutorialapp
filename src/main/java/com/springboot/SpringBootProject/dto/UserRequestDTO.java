package com.springboot.SpringBootProject.dto;

public class UserRequestDTO {
	
	private String firstName;
	private String lastName;
	private String password;
	private String reenterpasssowrd;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReenterpasssowrd() {
		return reenterpasssowrd;
	}
	public void setReenterpasssowrd(String reenterpasssowrd) {
		this.reenterpasssowrd = reenterpasssowrd;
	}
	
	

}
