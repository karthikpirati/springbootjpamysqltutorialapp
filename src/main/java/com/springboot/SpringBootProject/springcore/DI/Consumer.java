package com.springboot.SpringBootProject.springcore.DI;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/*
 * @Component annotation is added to the class, so that when Spring framework will scan for the components, 
 * this class will be treated as component. 
 * @Component annotation can be applied only to the class and it’s retention policy is Runtime.
 */
@Component
public class Consumer {
	
		public Consumer() {
			System.out.println("Consumer constructor");
		}
	
		// qualifier decides which bean to inject (watsapp or email)
		@Qualifier("email")
		@Autowired // will inject reference of specific bean into below referenced variable messageService
		private MessagingService messageService;
	
	
	 	@PostConstruct
	    public void customInit() 
	    {
	        System.out.println("Method conusmer customInit() invoked...");
	    }
	     
	    @PreDestroy
	    public void customDestroy() 
	    {
	        System.out.println("Method customDestroy() invoked...");
	    }
	
	/*
	 * Constructor injection
	 */
	
	//@Autowired
	public Consumer(MessagingService messageService) {
		this.messageService=messageService;
	}

	/*
	 * Setter injection
	 */
	//@Autowired
	public void setMessageService(MessagingService messageService) {
		this.messageService = messageService;
	}
	
	
	public void processMessage() {
		this.messageService.sendMessage("hello");
	}
	
	
	
	
	
	
	

}
