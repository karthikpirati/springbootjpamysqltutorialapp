package com.springboot.SpringBootProject.service.oneotmany;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Comment;

public interface CommentService {
	
	public Page<Comment> getCommentsByPostId(int postId,Pageable pageable);
	public Comment getCommentByIdAndPostId(int id,int postId);

}
