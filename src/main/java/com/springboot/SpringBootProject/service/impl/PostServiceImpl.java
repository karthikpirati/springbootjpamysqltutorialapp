package com.springboot.SpringBootProject.service.impl;


import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Post;
import com.springboot.SpringBootProject.repository.onetomany.PostRepository;
import com.springboot.SpringBootProject.service.oneotmany.PostService;

@Service
@Scope("prototype")
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post update(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void delete(int postId) {
		Optional<Post> opt=postRepository.findById(postId);
		if(opt.isPresent()) {
			postRepository.delete(opt.get());
		}
	}

	@Override
	public Post get(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Post> getAll(Pageable pageable) {
		/*
		 * this is same as mysql limit query
		 * limit first parameter is offset(it will choose offset-1 as first row)
		 * limit second parameter is row count(how many rows to fetch from offset)
		 * if we want fetch records between 11 to 30
		 * select * from post limit 10,20;  
		 */
		return postRepository.findAll(pageable);
	}

	



}
