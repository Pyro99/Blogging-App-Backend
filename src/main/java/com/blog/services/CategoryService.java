package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payload.CategoryDto;

@Service
public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	List<CategoryDto> getAllCategories(); 
	
	CategoryDto getCategoryById(int categoryId);
	
	CategoryDto updateCategory(CategoryDto categoryDto ,int id);
	
	void deleteCategory(int id);

}
