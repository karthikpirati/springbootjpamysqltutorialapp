package com.springboot.SpringBootProject.controller.manytomany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.models.relations.manytomany.Channel;
import com.springboot.SpringBootProject.service.maytomany.ChannelService;

@RestController
@RequestMapping(value="/channel")
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@PostMapping
	public Channel save(@RequestBody Channel channel) {
		//System.out.println(PageRequest.of(0, 10));
		return channelService.save(channel);
	}
	
	@PutMapping
	public Channel update(@RequestBody Channel channel) {
		//System.out.println(PageRequest.of(0, 10));
		return channelService.update(channel);
	}
	
	@GetMapping("/subscribe/{subId}/{channelId}")
	public Channel subscribe(@PathVariable("subId") int subId, @PathVariable("channelId") int channelId) {
		//System.out.println(PageRequest.of(0, 10));
		return channelService.subscribe(subId,channelId);
	}
	
	@GetMapping(value="/{id}/{page}/{size}")
	public Page<Channel> getbySubscriberIdWithPageqble(
			@PathVariable("id") int subId,
			@PathVariable("page") int page,
			@PathVariable("size") int size
			) {
		Pageable pageable=PageRequest.of(page, size,Sort.by("id").ascending());
		return channelService.findBySubscribers_Id(subId, pageable);
	}
	
	@GetMapping(value="/{id}")
	public List<Channel> getbySubscriberId(
			@PathVariable("id") int subId
			) {
		return channelService.findChannelBySubscriberId(subId);
	}
	
	
	@GetMapping
	public List<Channel> findAll() {
		return channelService.findAll();
	}
	
//	@GetMapping
//	public List<Channel> getbySubscriberIdNatively(
//			@RequestParam("id") int subId
//			) {
//		return channelService.findBySubscribersIdNative(subId);
//	}

}
