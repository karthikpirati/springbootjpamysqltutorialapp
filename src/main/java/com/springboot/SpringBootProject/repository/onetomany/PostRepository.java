package com.springboot.SpringBootProject.repository.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
