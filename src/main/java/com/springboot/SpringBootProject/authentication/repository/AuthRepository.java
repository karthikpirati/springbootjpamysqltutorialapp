package com.springboot.SpringBootProject.authentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.authentication.model.AuthUser;

@Repository
public interface AuthRepository extends JpaRepository<AuthUser, String>{
	
	//@Query(nativeQuery = true, "" )
	// delete from user where email='';
//	public void deletebyEmail(String email);
//	public List<AuthUser> findByEmail(String email);
}
