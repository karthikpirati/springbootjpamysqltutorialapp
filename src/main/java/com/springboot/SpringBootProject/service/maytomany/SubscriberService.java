package com.springboot.SpringBootProject.service.maytomany;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.SpringBootProject.models.relations.manytomany.Subscriber;

public interface SubscriberService {
	
	public Subscriber save(Subscriber subscriber);
	public Subscriber update(Subscriber subscriber);
	public void delete(int id);
	public Subscriber get(int id);
	public Page<Subscriber> findBySubscriberId(int channelId,Pageable pageable);

}
