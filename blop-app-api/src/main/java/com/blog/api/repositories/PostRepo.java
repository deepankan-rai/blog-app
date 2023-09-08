package com.blog.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entity.Category;
import com.blog.api.entity.Post;
import com.blog.api.entity.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
//	these are custome finder methods
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
