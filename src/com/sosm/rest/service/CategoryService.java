package com.sosm.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sosm.rest.entity.Categories;

@Service
public interface CategoryService {

	public List<Categories> getCategories();

	public void saveCategory(Categories category);

	public Categories getCategory(int id);

	public void deleteCategory(int id);
	
}
