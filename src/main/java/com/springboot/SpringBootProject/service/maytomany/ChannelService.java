package com.springboot.SpringBootProject.service.maytomany;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.SpringBootProject.models.relations.manytomany.Channel;

public interface ChannelService {
	
	public Channel save(Channel channel);
	public Channel save(Channel channel,int subId);
	public Channel update(Channel channel);
	public void delete(int id);
	public Channel findById(int id);
	public List<Channel> findChannelBySubscriberId(int subId);
	public Page<Channel> findBySubscribers_Id(int subId,Pageable pageable);
	public List<Channel> findBySubscribersIdNative(int subId);

}
