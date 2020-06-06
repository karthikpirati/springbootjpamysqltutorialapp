package com.springboot.SpringBootProject.springcore.DI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {
	
	/*
	 * @Bean can be used to prepare data before while server is starting
	 */
	@Bean
	public void getService(){
//		System.out.println("Bean injection");
//		return new EmailService();
	}

}
