package com.springboot.SpringBootProject.models.relations.onetomany.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int id;
	private String text;
	
	/*
	 * By default ManyToOne is eager 
	 * So it will fetch Post data even thjough we dont access it
	 * You will observe output as below
	 * But post is not needed
	 {
      "commentId": 11,
      "text": "comment1 : 11",
      "post": {
        "id": 1,
        "description": "post desc31"
      }
    }
	 * So ignore Post by choosing fetch=FetchType.LAZY
	 * And important to use @JsonIgnore on Post
	 * Check for details below
	 */
	//@ManyToOne
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id")
	private Post post;
	//private int post_id;
	
	public Comment() {
		super();
	}
	
	
	public Comment(String text, Post post) {
		super();
		this.text = text;
		this.post = post;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	/*
	 * Jacksonbind.jar is responsible for serializing and deserializing the java object
	 * If we choose FetchType.Lazy 
	 * Then hibernate will not fetch Post details unnecessarily
	 * Now Jacksonbind.jar tries to deserializing the Pots objext
	 * But due to  FetchType.Lazy post is not avaialble 
	 * so we will get an error when Jacksonbind.jar tries to deserializing Post object
	 * So choose JsonIgnore to ignore the Post property
	 */
	@JsonIgnore
	public Post getPost() {
		return post;
	}
	@JsonIgnore
	public void setPost(Post post) {
		this.post = post;
	}
	
	
	

}
