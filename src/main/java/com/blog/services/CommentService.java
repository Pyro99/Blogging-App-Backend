package com.blog.services;

import org.springframework.stereotype.Service;

import com.blog.payload.CommentDto;

@Service
public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, int postId);
	
	void deleteComment(int commentId);
	
	

}
