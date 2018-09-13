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

import com.sosm.rest.entity.Types;
import com.sosm.rest.exceptions.TypeNotFoundException;
import com.sosm.rest.service.TypeService;

@RestController
@RequestMapping("/type")
public class TypeRestController {

	// autowire the CustomerService
		@Autowired
		private TypeService typeService;
		
		// add mapping for GET /customers
		@GetMapping("/types")
		public List<Types> getTypes() {
			
			return typeService.getTypes();
			
		}
		
		// add mapping for GET /customers/{customerId}
		
		@GetMapping("/types/{type_Id}")
		public Types getType(@PathVariable int type_Id) {
			
			Types type = typeService.getType(type_Id);
			
			if (type == null) {
				throw new TypeNotFoundException("Type id not found - " + type_Id);
			}
			
			return type;
		}
		
		// add mapping for POST /customers  - add new customer
		
		@PostMapping("/types")
		public Types addType(@RequestBody Types type) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is force a save of new item ... instead of update
			
			type.setType_Id(0);
			
			typeService.saveTypes(type);
			
			return type;
		}
		
		// add mapping for PUT /customers - update existing customer
		
		@PutMapping("/types")
		public Types updateType(@RequestBody Types type) {
			
			typeService.saveTypes(type);
			
			return type;
			
		}
		
		// add mapping for DELETE /customers/{customerId} - delete customer
		
		@DeleteMapping("/types/{type_Id}")
		public String deleteType(@PathVariable int type_Id) {
			
			Types type = typeService.getType(type_Id);
			
			// throw exception if null
			
			if (type == null) {
				throw new TypeNotFoundException("Type id not found - " + type_Id);
			}
					
			typeService.deleteType(type_Id);
			
			return "Deleted type id - " + type_Id;
		}
		
}
