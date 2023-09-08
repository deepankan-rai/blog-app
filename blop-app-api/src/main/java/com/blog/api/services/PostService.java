package com.blog.api.services;


import com.blog.api.payloads.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	void deletePsot(Integer postId);

	

}
