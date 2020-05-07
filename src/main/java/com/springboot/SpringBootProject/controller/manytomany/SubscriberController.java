package com.springboot.SpringBootProject.controller.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
