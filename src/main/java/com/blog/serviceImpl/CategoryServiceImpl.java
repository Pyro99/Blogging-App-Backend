package com.blog.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payload.CategoryDto;
import com.blog.repositories.CategoryRepo;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category savedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = this.categoryRepo.findAll();
//		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
//		for(Category list : categories)
//		{
//			categoryDtos.add(this.modelMapper.map(list, CategoryDto.class));
//		}
		
		List<CategoryDto> categoryDtos = categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
		return categoryDtos;
	}

	@Override
	public CategoryDto getCategoryById(int categoryId) {

		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
			
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
		
		Category category = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", id));
		
		if (Objects.nonNull(categoryDto.getCategoryTitle()) && !"".equalsIgnoreCase(categoryDto.getCategoryTitle())) 
		{
			category.setCategoryTitle(categoryDto.getCategoryTitle());
		}
		
		if (Objects.nonNull(categoryDto.getCategoryDescription()) && !"".equalsIgnoreCase(categoryDto.getCategoryDescription())) 
		{
			category.setCategoryDescription(categoryDto.getCategoryDescription());
		}
		Category updatedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(int id) {
		
		Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", id));
		this.categoryRepo.delete(category);
		
	}

}
