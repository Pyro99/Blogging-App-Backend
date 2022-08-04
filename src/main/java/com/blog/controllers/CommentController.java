package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.ApiResponse;
import com.blog.payload.CommentDto;
import com.blog.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<CommentDto> addComment(@PathVariable int postId, @RequestBody CommentDto comment)
	{
		CommentDto createdComment = this.commentService.createComment(comment, postId);
		return new ResponseEntity<CommentDto>(createdComment , HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<ApiResponse> addComment(@PathVariable int commentId)
	{
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("comment deleted successfully",true) , HttpStatus.OK);
		
	}
}
