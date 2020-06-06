package com.springboot.SpringBootProject.springcore.DI;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailService implements MessagingService{

	@Override
	public void sendMessage(String message)  {
		System.out.println("sending message through email");
	}

}
