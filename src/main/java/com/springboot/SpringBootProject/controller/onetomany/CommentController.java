package com.springboot.SpringBootProject.controller.onetomany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Comment;
import com.springboot.SpringBootProject.service.oneotmany.CommentService;

@RestController
@RequestMapping(value="/post/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	//@RequestMapping(name = "/{id}", method = RequestMethod.GET)
	@GetMapping(value="/{id}/{pageNo}/{pageSize}")
	public ResponseEntity<?> getCommentByPostId(
			@PathVariable("id") int id,
			@PathVariable("pageNo") int pageNo,
			@PathVariable("pageSize") int pageSize
			) {
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		List<Comment> commentsByPagination=commentService.getCommentsByPostId(id, pageable);
		return new ResponseEntity<List<Comment>>(commentsByPagination,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}/{postId}")
	public Comment getCommentByIdAndPostId(@PathVariable("id") int id,@PathVariable("postId") int postId) {
		return commentService.getCommentByIdAndPostId(id, postId);
	}

}
