package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.payload.PostDto;
import com.blog.payload.PostResponse;

@Service
public interface PostService {

	PostDto createPost(PostDto postDto, int userId, int categoryId);
	
	PostDto updatePost(PostDto postDto, int postId);
	
	void deletePost(int postId);
	
	PostResponse getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir);
	
	PostDto getPostById(int postId);
	
	List<PostDto> getPostbyUser(int userID);
	
	List<PostDto> getPostByCategory(int categoryId);
	
	List<PostDto> searchPosts(String keyword);
	
}
