package com.springboot.SpringBootProject.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Comment;
import com.springboot.SpringBootProject.repository.onetomany.CommentRepository;
import com.springboot.SpringBootProject.service.oneotmany.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Page<Comment> getCommentsByPostId(int postId,Pageable pageable) {
		
		return commentRepository.findByPostId(postId, pageable);
	}

	@Override
	public Comment getCommentByIdAndPostId(int id, int postId) {
		Optional<Comment> isComment=commentRepository.findByIdAndPostId(id, postId);
		return isComment.get();
	}

}
