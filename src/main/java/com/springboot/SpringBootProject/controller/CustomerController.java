package com.springboot.SpringBootProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.models.Customer;
import com.springboot.SpringBootProject.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	
	private CustomerService customerService; // = new CustomerService();
	
	@Autowired
	public CustomerController(CustomerService customerService) {

		this.customerService = customerService;
	}
	/*
	 * post and put we will send our data in RequestBody
	 * @RequestBody
	 * 
	 * Get and Delete we will append data to url
	 * http://localhost:port/customer/2 --- @PathVariable
	 * http://localhost:port/customer?id=1 --- @RequestParam
	 */
	
	@PostMapping
	public Customer save(@RequestBody Customer customer) {
		
		return this.customerService.save(customer);
	}
	
	
	
	@PutMapping
	public Customer update(@RequestBody Customer customer) {
		
		return this.customerService.save(customer);
	}
	
	@GetMapping(value="/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		return new Customer();
	}
	
	@GetMapping(value="/byId")
	public Customer getCustomerByRequest(@RequestParam("id") int id) {
		return new Customer();
	}
	
	@GetMapping
	public Customer getCustomerByAgeRequest(@RequestParam("id") int id,@RequestParam("age") int age) {
		return new Customer();
	}
	
	@GetMapping(value="/{age}")
	public Customer getCustomerByAge(@PathVariable int age) {
		return new Customer();
	}
	
	@DeleteMapping(value="/{id}")
	public Customer deleteCustomer(@PathVariable int id) {
		return new Customer();
	}

}
