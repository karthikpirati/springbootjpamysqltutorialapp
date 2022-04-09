package com.springboot.SpringBootProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	//jpa repo methid always we wll use class properties
	List<Customer> findByCustName(String custName); // find-select * from customer  by - where cust_name='';
	
//	@Query(value="select * from customer where cust_name=:custName",nativeQuery=true)
//	List<Customer> findByCustName(String custName);
	

}
