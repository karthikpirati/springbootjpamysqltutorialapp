package com.springboot.SpringBootProject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.models.relations.manytomany.Channel;
import com.springboot.SpringBootProject.models.relations.manytomany.Subscriber;
import com.springboot.SpringBootProject.repository.manytomany.ChannelRepository;
import com.springboot.SpringBootProject.repository.manytomany.SubscriberRepository;
import com.springboot.SpringBootProject.service.maytomany.ChannelService;


@Service
public class ChannelServiceImpl implements ChannelService{
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private SubscriberRepository subscriberRepository;

	@Override
	public Channel save(Channel channel, int subId) {
		Optional<Subscriber> isSubscriber=subscriberRepository.findById(subId);
		if(isSubscriber.isPresent()) {
			channel.getSubscribers().add(isSubscriber.get());
		}
		return channelRepository.save(channel);
	}

	@Override
	public Channel update(Channel channel) {
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Channel save(Channel channel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Channel findById(int id) {
		return null;
	}

	@Override
	public List<Channel> findChannelBySubscriberId(int subId) {
		return channelRepository.findBySubscribers_Id(subId);
	}

	@Override
	public Page<Channel> findBySubscribers_Id(int subId, Pageable pageable) {
		
		return channelRepository.findBySubscribers_Id(subId, pageable);
	}

	@Override
	public List<Channel> findBySubscribersIdNative(int subId) {
		List<Channel> channels=new ArrayList<Channel>();
		List<Object[]> list=channelRepository.findBySubscribersId(subId);
		for(Object[] o:list) {
			Channel c=new Channel();
			c.setId((int)o[1]);
			channels.add(c);
		}
		return null;
	}

	

}
