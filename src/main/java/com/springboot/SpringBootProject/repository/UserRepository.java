package com.springboot.SpringBootProject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.models.User;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public Optional<User> findByEmail(String email);
    public List<User> findByEmailContains(String email);
}
