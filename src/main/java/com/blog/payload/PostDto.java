package com.blog.payload;

import java.util.Date;
import java.util.List;

import com.blog.entities.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	
	private int postId;
	
	private String postTitle;
	
	private String postContent;
	
	private Date postAddDate;
	
	private UserDto user;
	
	private CategoryDto category;
 	
	private List<CommentDto> comments;
	

}
