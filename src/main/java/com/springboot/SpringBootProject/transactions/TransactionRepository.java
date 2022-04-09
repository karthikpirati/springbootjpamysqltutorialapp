package com.springboot.SpringBootProject.transactions;

import com.springboot.SpringBootProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<User, Integer> {
}
