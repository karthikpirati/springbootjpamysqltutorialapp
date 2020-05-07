package com.springboot.SpringBootProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.models.Customer;
import com.springboot.SpringBootProject.repository.CustomerRepository;
import com.springboot.SpringBootProject.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		// business logic
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer delete(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer get(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
