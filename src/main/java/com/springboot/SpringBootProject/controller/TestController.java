package com.springboot.SpringBootProject.controller;

import org.springframework.web.bind.annotation.*;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Post;

@RestController
@CrossOrigin("*")
public class TestController {
	
	@PostMapping("/testcon")
	public String test(@RequestBody Post post) {
		System.out.println("test method");
		return "TestController test method";
	}

	@GetMapping("/testget")
	public String test() {
		System.out.println("test method");
		return "TestController test method";
	}

}
