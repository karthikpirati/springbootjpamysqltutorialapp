package com.springboot.SpringBootProject.springcore.DI;

import org.springframework.stereotype.Service;

@Service("watsapp")
public class WatsAppService implements MessagingService{

	@Override
	public void sendMessage(String message) {
		System.out.println("sending message through watsapp");
	}

}
