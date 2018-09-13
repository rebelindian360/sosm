package com.sosm.rest.dao;

import java.util.List;

import com.sosm.rest.entity.Categories;

public interface CategoryDAO {

	public List<Categories> getCategories();

	public void saveCategory(Categories category);

	public Categories getCategory(int id);

	public void deleteCategory(int id);
	
}