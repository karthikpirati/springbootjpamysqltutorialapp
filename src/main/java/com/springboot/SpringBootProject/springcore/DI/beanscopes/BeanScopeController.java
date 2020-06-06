package com.springboot.SpringBootProject.springcore.DI.beanscopes;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * by default bean scope is singleton
 * but we have other scopes like request,session,prototype
 * prototpe : every time when we access component it will create a new object
 * in this example new object of BeanScopeController will be created
 
 * request : for every http request new object will be created
 * eg : http://loocalhost:port/beanScopes
 * for every hit it will create the object
 
 * session : 
 * whenever client makes a request to server, it will create cookie with name JSESSIONID	
 * and return to client.
 * You can observe this JSESSIONID in cookie tab of insomnia
 * Next time if same client makes request JSESSIONID is passed to server
 * and server understood based on it
 
 * Let say we make a request from insomnia a new HttpSession object will be create
 * if we make a request from imsomnia it will create a new bean for those whose scope is session
 * if we try to make any request from insomnia gain it will not create a new bean because we are
 * making request from same session
 
 * try making request from chrome/any appliocation/incognito mode of chrome it will create new httpsession
 * important methods to work with session
 

 * 
 * request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
 * request.getSession().getAttribute("MY_SESSION_MESSAGES");
 * request.getSession().invalidate();
 */

@RequestMapping(value="/beanScopes")
@RestController
@Scope("request")
public class BeanScopeController {
	
	@Autowired
	private BeanService b;
	
	public BeanScopeController() {
		System.out.println("bean scope controller");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("bean init");
	}
	
	@GetMapping
	public String get() {
		 return b.m1();
	}
	
	
	

}
