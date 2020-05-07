package com.springboot.SpringBootProject.repository.manytomany;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.models.relations.manytomany.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer>{
	
	/*
	 * Fetching all subscribers by channel id
	 * Internally this is making left outer join
	 * 
	 	Select * from subscriber s 
	 	left outer join channel_subscriber
	 	on subscriber.sub_id=channel_subscriber.sub_id
	 	left outer join channel
	 	on channel.sub_id=channel_subscriber.channel_id
	 	where channel_id=?
	 */
	public Page<Subscriber> findByChannels_Id(int channelId,Pageable pageable);

}
