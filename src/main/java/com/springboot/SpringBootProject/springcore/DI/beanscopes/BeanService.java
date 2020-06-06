package com.springboot.SpringBootProject.springcore.DI.beanscopes;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
public class BeanService {
	
	
	public BeanService() {
		System.out.println("bean service");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("bean init");
	}
	
	public String m1() {
		return "scope check";
	}

}
