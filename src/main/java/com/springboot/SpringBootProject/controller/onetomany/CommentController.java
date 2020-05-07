package com.springboot.SpringBootProject.controller.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Comment;
import com.springboot.SpringBootProject.service.oneotmany.CommentService;

@RestController
@RequestMapping(value="/post/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Page<Comment>> getCommentByPostId(@PathVariable("id") int id) {
		Pageable pageable=PageRequest.of(1, 10);
		Page<Comment> commentsByPagination=commentService.getCommentsByPostId(id, pageable);
		return new ResponseEntity<Page<Comment>>(commentsByPagination,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}/{postId}")
	public Comment getCommentByIdAndPostId(@PathVariable("id") int id,@PathVariable("postId") int postId) {
		return commentService.getCommentByIdAndPostId(id, postId);
	}

}
