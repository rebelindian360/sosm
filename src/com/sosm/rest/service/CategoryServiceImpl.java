package com.sosm.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sosm.rest.dao.CategoryDAO;
import com.sosm.rest.entity.Categories;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public List<Categories> getCategories() {
		return categoryDAO.getCategories();
	}

	@Override
	@Transactional
	public void saveCategory(Categories category) {
		categoryDAO.saveCategory(category);

	}

	@Override
	@Transactional
	public Categories getCategory(int id) {
		
		return categoryDAO.getCategory(id);
	}

	@Override
	@Transactional
	public void deleteCategory(int id) {
		categoryDAO.deleteCategory(id);

	}

}
