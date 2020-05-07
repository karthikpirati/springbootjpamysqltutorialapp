package com.springboot.SpringBootProject.repository.manytomany;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.models.relations.manytomany.Channel;
import com.springboot.SpringBootProject.models.relations.manytomany.Subscriber;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer>{
	
	public List<Channel> findBySubscribers_Id(int subId);
	/*
	 * Fetching All Channels by subscriber id
	 * Internally it is making the left outer join 
	  
	  select * from channel c
	  left outer join channel_subscriber cs
	  on c.channel_id=cs.channel_id
	  left outer join subscriber s
	  on cs.sub_id=s.sub_id
	  where s.sub_id=?
	 
	 */
	public Page<Channel> findBySubscribers_Id(int subId,Pageable pageable);
	
	@Query(value="select * from channel as c left outer join channel_subscriber as cs on c.id=cs.channel_id left outer join subscriber as s on cs.sub_id=s.id where s.id=?",nativeQuery=true)
	public List<Object[]> findBySubscribersId(int subId);
	

}
