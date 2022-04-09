package com.springboot.SpringBootProject.service.oneotmany;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Comment;

public interface CommentService {
	
	public List<Comment> getCommentsByPostId(int postId,Pageable pageable);
	public Comment getCommentByIdAndPostId(int id,int postId);

}
