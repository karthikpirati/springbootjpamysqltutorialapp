package com.springboot.SpringBootProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.models.relations.manytomany.Subscriber;
import com.springboot.SpringBootProject.repository.manytomany.SubscriberRepository;
import com.springboot.SpringBootProject.service.maytomany.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService{
	
	@Autowired
	private SubscriberRepository subscriberRepository;


	@Override
	public Subscriber save(Subscriber subscriber) {
		return subscriberRepository.save(subscriber);
	}

	@Override
	public Subscriber update(Subscriber subscriber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Subscriber get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Subscriber> findBySubscriberId(int channelId, Pageable pageable) {
		return subscriberRepository.findByChannels_Id(channelId, pageable);
	}

}
