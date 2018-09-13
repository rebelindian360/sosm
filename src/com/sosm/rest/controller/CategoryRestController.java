package com.sosm.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sosm.rest.entity.Categories;
import com.sosm.rest.entity.Categories;
import com.sosm.rest.exceptions.CategoryNotFoundException;
import com.sosm.rest.exceptions.LanguageNotFoundException;
import com.sosm.rest.service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryRestController {

	
	// autowire the CustomerService
		@Autowired
		private CategoryService categoryService;
		
		// add mapping for GET /customers
		@GetMapping("/categories")
		public List<Categories> getCategories() {
			
			return categoryService.getCategories();
			
		}
		
		// add mapping for GET /customers/{customerId}
		
		@GetMapping("/categories/{category_Id}")
		public Categories getCategory(@PathVariable int category_Id) {
			
			Categories category = categoryService.getCategory(category_Id);
			
			if (category == null) {
				throw new CategoryNotFoundException("Category id not found - " + category_Id);
			}
			
			return category;
		}
		
		// add mapping for POST /customers  - add new customer
		
		@PostMapping("/categories")
		public Categories addCategory(@RequestBody Categories category) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is force a save of new item ... instead of update
			
			category.setCategory_Id(0);
			
			categoryService.saveCategory(category);
			
			return category;
		}
		
		// add mapping for PUT /customers - update existing customer
		
		@PutMapping("/Categories")
		public Categories updateCategory(@RequestBody Categories category) {
			
			categoryService.saveCategory(category);
			
			return category;
			
		}
		
		// add mapping for DELETE /customers/{customerId} - delete customer
		
		@DeleteMapping("/Categories/{category_Id}")
		public String deleteCategory(@PathVariable int category_Id) {
			
			Categories category = categoryService.getCategory(category_Id);
			
			// throw exception if null
			
			if (category == null) {
				throw new CategoryNotFoundException("Category id not found - " + category_Id);
			}
					
			categoryService.deleteCategory(category_Id);
			
			return "Deleted language id - " + category_Id;
		}
		
}
