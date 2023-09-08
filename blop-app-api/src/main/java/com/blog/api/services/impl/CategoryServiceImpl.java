package com.blog.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entity.Category;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.repositories.CategoryRepo;
import com.blog.api.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addCat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category","CatId",catId));
		cat.setCatTitle(categoryDto.getCatTitle());
		cat.setCatDescription(categoryDto.getCatDescription());
		
		Category updateCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(updateCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer catId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category","CatId",catId));
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer catId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category","CatId",catId));
		
		return this.modelMapper.map(cat,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		List<Category> cat=this.categoryRepo.findAll();
		List<CategoryDto> catDtos= cat.stream().map((categories)->this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
