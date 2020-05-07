package com.springboot.SpringBootProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.models.Customer;
import com.springboot.SpringBootProject.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer save(@RequestBody Customer customer) {
		
		return this.customerService.save(customer);
	}

}
