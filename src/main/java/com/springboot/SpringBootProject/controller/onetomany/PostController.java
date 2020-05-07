package com.springboot.SpringBootProject.controller.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Post;
import com.springboot.SpringBootProject.service.oneotmany.PostService;

@RestController
@RequestMapping(value="/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	/*
	 * 
	 */
	@GetMapping
	public ResponseEntity<Page<Post>> getAllPosts() {
		/*
		 * Pageable is used to fetch data with pagination and sorting
		 * PageRequest.of contains three parameters
		 * pageNumber 
		 * pageSize
		 * On which field we want to sort
		 * since internally it is limit query which takes offset and row count
		 * offset = pagesize+pageNumber
		 * rowCount= pagesize
		 */
		Pageable pageable=PageRequest.of(2, 15,Sort.by("description").descending());
		Page<Post> postListWithPageable=postService.getAll(pageable);
		return new ResponseEntity<Page<Post>>(postListWithPageable, new HttpHeaders(), HttpStatus.OK); 
	}
	
	
	@PostMapping
	public Post save(@RequestBody Post post) {
		//System.out.println(PageRequest.of(0, 10));
		return postService.save(post);
	}

}
