package com.springboot.SpringBootProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.models.Customer;


public interface CustomerService {
	
	public Customer save(Customer customer);
	public Customer update(Customer customer);
	public Customer delete(int custId);
	public Customer get(int custId);
	public List<Customer> getAll();

}
