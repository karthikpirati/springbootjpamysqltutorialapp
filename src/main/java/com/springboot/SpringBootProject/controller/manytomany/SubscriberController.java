package com.springboot.SpringBootProject.controller.manytomany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.models.relations.manytomany.Subscriber;
import com.springboot.SpringBootProject.service.maytomany.SubscriberService;

@RestController
@RequestMapping(value="/subscriber")
public class SubscriberController {
	
	@Autowired
	private SubscriberService subscriberService;
	
	@PostMapping
	public Subscriber save(@RequestBody Subscriber subscriber) {
		//System.out.println(PageRequest.of(0, 10));
		return subscriberService.save(subscriber);
	}
	
	@PostMapping("/post2")
	public Subscriber post(@RequestBody Subscriber subscriber) {
		//System.out.println(PageRequest.of(0, 10));
		return subscriberService.save(subscriber);
	}
	
	@PutMapping
	public Subscriber update(@RequestBody Subscriber subscriber) {
		//System.out.println(PageRequest.of(0, 10));
		return subscriberService.update(subscriber);
	}
	
	@GetMapping
	public List<Subscriber> findAll() {
		//System.out.println(PageRequest.of(0, 10));
		return subscriberService.findAll();
	}
	
	@GetMapping("/{id}")
	public Subscriber findById(@PathVariable("id") int id) {
		//System.out.println(PageRequest.of(0, 10));
		return subscriberService.get(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id) {
		//System.out.println(PageRequest.of(0, 10));
		subscriberService.delete(id);
	}
	
	
	@GetMapping(value="/{id}/{page}/{size}")
	public Page<Subscriber> getbyChannelIdWithPageqble(
			@PathVariable("id") int channelId,
			@PathVariable("page") int page,
			@PathVariable("size") int size
			) {
		Pageable pageable=PageRequest.of(page, size);
		return subscriberService.findBySubscriberId(channelId, pageable);
	}
	
}
