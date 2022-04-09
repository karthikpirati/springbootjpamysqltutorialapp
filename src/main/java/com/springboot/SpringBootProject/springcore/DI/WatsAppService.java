package com.springboot.SpringBootProject.springcore.DI;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("watsapp")
//@Primary
public class WatsAppService implements MessagingService{

	@Override
	public void sendMessage(String message) {
		System.out.println("sending message through watsapp");
	}

}
