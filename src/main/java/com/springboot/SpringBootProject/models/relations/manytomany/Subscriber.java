package com.springboot.SpringBootProject.models.relations.manytomany;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name",unique=true,nullable = false,length = 20)
	private String name;
	
		@ManyToMany(mappedBy="subscribers",
				cascade = {
						CascadeType.PERSIST,
						CascadeType.MERGE
				},
				fetch=FetchType.LAZY)
		@JsonIgnore
		private Set<Channel> channels=new HashSet<Channel>();
	
	public Subscriber() {
		
	}
	
	public Subscriber(String name) {
		super();
		this.name = name;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}
	

	
	
	

}
