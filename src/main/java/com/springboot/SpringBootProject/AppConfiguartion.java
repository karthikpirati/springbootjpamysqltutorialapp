package com.springboot.SpringBootProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.SpringBootProject.models.relations.manytomany.Channel;
import com.springboot.SpringBootProject.models.relations.manytomany.Subscriber;
import com.springboot.SpringBootProject.repository.manytomany.ChannelRepository;
import com.springboot.SpringBootProject.repository.manytomany.SubscriberRepository;
import com.springboot.SpringBootProject.repository.onetomany.CommentRepository;
import com.springboot.SpringBootProject.repository.onetomany.PostRepository;

@Configuration
public class AppConfiguartion {
	
//	@Autowired
//	private PostRepository postRepository;
//	
//	@Autowired
//	private CommentRepository commentRepository;
//	
//	@Autowired
//	private ChannelRepository channelRepository;
//	
//	@Autowired
//	private SubscriberRepository subscriberRepository;
	
	@Bean
	public void preparePostData() {
		
		
		
		
		
//		Channel c1=new Channel("java");
//		Channel c2=new Channel("springboot");
//		Channel c3=new Channel("hibernate");
//		
//		List<Subscriber> subs1;
//		List<Subscriber> subs2;
//		List<Subscriber> subs3;
//		
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=1;i<=10;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
//		
//		subs2=new ArrayList<Subscriber>();
//		for(int i=11;i<=20;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs2.add(s);
//		}
//		
//		c2.getSubscribers().addAll(subs2);
//		channelRepository.save(c2);
//		
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=21;i<=30;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
//		
//		subs3=new ArrayList<Subscriber>();
//		for(int i=31;i<=40;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs3.add(s);
//		}
//		
//		c3.getSubscribers().addAll(subs3);
//		channelRepository.save(c3);
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=41;i<=60;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
//		
//		subs2=new ArrayList<Subscriber>();
//		for(int i=61;i<=80;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs2.add(s);
//		}
//		
//		c2.getSubscribers().addAll(subs2);
//		channelRepository.save(c2);
//		
//		
//		subs1=new ArrayList<Subscriber>();
//		for(int i=81;i<=90;i++) {
//			Subscriber s=new Subscriber("subscriber : "+i);
//			subscriberRepository.save(s);
//			subs1.add(s);
//		}
//		
//		c1.getSubscribers().addAll(subs1);
//		channelRepository.save(c1);
		
//		for(int i=31;i<=40;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		for(int i=1;i<=10;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		for(int i=41;i<=50;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		for(int i=21;i<=30;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		for(int i=11;i<=20;i++) {
//			Post p=new Post("post desc"+i);
//			postRepository.save(p);
//		}
//		
//		Optional<Post> ispost=postRepository.findById(1);
//		if(ispost.isPresent()) {
//			for(int i=1;i<=500;i++) {
//				Comment c1=new Comment("comment1 : "+i,ispost.get());
//				commentRepository.save(c1);
//			}
//		}
//		
//		Optional<Post> ispost2=postRepository.findById(2);
//		if(ispost2.isPresent()) {
//			for(int i=1;i<=500;i++) {
//				Comment c1=new Comment("comment2 : "+i,ispost2.get());
//				commentRepository.save(c1);
//			}
//		}
//		
		
		
		
		
	}

}
