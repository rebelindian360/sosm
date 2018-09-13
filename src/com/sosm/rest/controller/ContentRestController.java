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

import com.sosm.rest.entity.Content;
import com.sosm.rest.exceptions.ContentNotFoundException;
import com.sosm.rest.service.ContentService;

@RestController
@RequestMapping("/content")
public class ContentRestController {

	
	// autowire the CustomerService
		@Autowired
		private ContentService contentService;
		
		// add mapping for GET /customers
		@GetMapping("/contents")
		public List<Content> getContents() {
			
			return contentService.getContents();
			
		}
		
		// add mapping for GET /customers/{customerId}
		
		@GetMapping("/contents/{content_Id}")
		public Content getContent(@PathVariable int content_Id) {
			
			Content content = contentService.getContent(content_Id);
			
			if (content == null) {
				throw new ContentNotFoundException("Content id not found - " + content_Id);
			}
			
			return content;
		}
		
		// add mapping for POST /customers  - add new customer
		
		@PostMapping("/contents")
		public Content addContent(@RequestBody Content content) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is force a save of new item ... instead of update
			
			content.setContent_Id(0);
			
			contentService.saveContent(content);
			
			return content;
		}
		
		// add mapping for PUT /customers - update existing customer
		
		@PutMapping("/contents")
		public Content updateContent(@RequestBody Content content) {
			
			contentService.saveContent(content);
			
			return content;
			
		}
		
		// add mapping for DELETE /customers/{customerId} - delete customer
		
		@DeleteMapping("/contents/{content_Id}")
		public String deleteContent(@PathVariable int content_Id) {
			
			Content content = contentService.getContent(content_Id);
			
			// throw exception if null
			
			if (content == null) {
				throw new ContentNotFoundException("Content id not found - " + content_Id);
			}
					
			contentService.deleteContent(content_Id);
			
			return "Deleted content id - " + content_Id;
		}
		
		
}
