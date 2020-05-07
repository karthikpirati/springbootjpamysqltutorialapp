package com.springboot.SpringBootProject.repository.onetomany;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject.models.relations.onetomany.uni.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	/*
	 * fetch Comments by postId
	 * we should name method carefully
	 * usually it is like findBy(Property Inside Comment Class)
	 * Comment class is a having a dependent class property private Post post
	 * Since Post is a class then 
	 * findBy(Dependent Property Inside Comment Class(private Post post of Comment))(Property Inside Dependent Class(Id property of post))
	 * findBy(Post)(Id)
	 * internally this will get converted to hql query as
	 * Select c from Comment c where c.post.id=:postId
	 * 
	 */
	Page<Comment> findByPostId(int postId,Pageable pageable);
	
	/*
	 * fetching Comments by Comment.Id and Post.Id
	 * findBy(Property of Comment Class) and (Property of Comment Class(Post))(Property of Comment Class Id)
	 */
	Optional<Comment> findByIdAndPostId(int id,int postId);

}
