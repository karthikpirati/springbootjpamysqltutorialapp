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

/*
 * The entity that specifies the @JoinTable is the owning side of the relationship 
 * and the entity that specifies the mappedBy attribute is the inverse side.
 * Channel is owning side of the relationship 
 * Subscriber is inverse side.
 */
@Entity
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false, unique = true, length = 20)
	private String name;

	/*
	 * Channel is the owner so pass channel_id to join columns sub_id to
	 * inverseJoinColumns
	 */

	/*
	 * use fetchType as lazy because if we use eager
	 */

	/*
	 * do not CascadeType.Remove because that does not make sense let say if someone
	 * remove youtube channels we should not all the subscriber acconts linked to
	 * youtube channel
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "channel_subscriber", joinColumns = { @JoinColumn(name = "channel_id") }, inverseJoinColumns = {
			@JoinColumn(name = "sub_id") })
	/*
	 * Ignore this otherwise it leads to circular dependency and leads to
	 * OutOfMemoryError
	 * 
	 * Channel internally using Set<Subscriber> Subscriber internally using
	 * Set<Channel> Let say we are converting java object Channel to Json Internally
	 * Channel using Set<Subscriber> so jaxkson.bind jar converts this
	 * Set<Subscriber> to json as part of this, each Subscriber internally use
	 * Set<Channel> so it again tries to convert Set<Channel> as part of this, each
	 * Channel internally use Set<Subscriber> which never stops
	 * 
	 */
	@JsonIgnore
	private Set<Subscriber> subscribers = new HashSet<Subscriber>();

	public Channel() {

	}

	public Channel(String name) {
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

	public Set<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + "]";
	}

}
