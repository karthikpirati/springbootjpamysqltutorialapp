package com.springboot.SpringBootProject.service.oneotmany;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.SpringBootProject.models.Customer;
import com.springboot.SpringBootProject.models.relations.onetomany.uni.Post;

public interface PostService {

	public Post save(Post post);
	public Post update(Post post);
	public void delete(int postId);
	public Post get(int postId);
	public Page<Post> getAll(Pageable pageable);
}
