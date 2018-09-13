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

import com.sosm.rest.entity.Languages;
import com.sosm.rest.exceptions.LanguageNotFoundException;
import com.sosm.rest.service.LanguageService;

@RestController
@RequestMapping("/lang")
public class LanguageRestController {

	// autowire the CustomerService
	@Autowired
	private LanguageService languageService;
	
	// add mapping for GET /customers
	@GetMapping("/languages")
	public List<Languages> getLanguages() {
		
		return languageService.getLanguages();
		
	}
	
	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/languages/{language_Id}")
	public Languages getLanguage(@PathVariable int language_Id) {
		
		Languages language = languageService.getLanguage(language_Id);
		
		if (language == null) {
			throw new LanguageNotFoundException("Language id not found - " + language_Id);
		}
		
		return language;
	}
	
	// add mapping for POST /customers  - add new customer
	
	@PostMapping("/languages")
	public Languages addLanguage(@RequestBody Languages language) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		language.setLanguage_Id(0);
		
		languageService.saveLanguages(language);
		
		return language;
	}
	
	// add mapping for PUT /customers - update existing customer
	
	@PutMapping("/languages")
	public Languages updateLanguage(@RequestBody Languages language) {
		
		languageService.saveLanguages(language);
		
		return language;
		
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/languages/{language_Id}")
	public String deleteLanguage(@PathVariable int language_Id) {
		
		Languages language = languageService.getLanguage(language_Id);
		
		// throw exception if null
		
		if (language == null) {
			throw new LanguageNotFoundException("Language id not found - " + language_Id);
		}
				
		languageService.deleteLanguage(language_Id);
		
		return "Deleted language id - " + language_Id;
	}
	
}

