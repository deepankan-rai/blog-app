package com.blog.api.services;

import java.util.List;

import com.blog.api.payloads.CategoryDto;

public interface CategoryService {
	
//	create
	public CategoryDto createCategory(CategoryDto categoryDto);

	
	//  update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer catId);
	
//	delete
	public void deleteCategory(Integer catId);
	
//	get
	public CategoryDto getCategory(Integer catId);
	
//	getall
	
	public List<CategoryDto> getCategories();
	
	
}
