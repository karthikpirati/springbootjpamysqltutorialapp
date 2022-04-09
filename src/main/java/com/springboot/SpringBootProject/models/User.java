package com.springboot.SpringBootProject.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String password;
	private String firstName;
	private String lastName;
	@Column(name="mobile_no", unique = true)
	private String mobileNo;
	@Column(name="email", unique = true)
	private String email;
	private Date dob;
	private byte gender;

}
