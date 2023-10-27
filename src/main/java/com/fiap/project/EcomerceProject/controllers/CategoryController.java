package com.fiap.project.EcomerceProject.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.project.EcomerceProject.dto.CategoryDTO;
import com.fiap.project.EcomerceProject.services.CategoryService;
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
		@Autowired
		private CategoryService service;
		
		@GetMapping
		public ResponseEntity<List<CategoryDTO>> findAll(){
			List<CategoryDTO> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		

		@PostMapping
		public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO categories){

			categories = service.insert(categories);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categories.getId()).toUri();
	        return ResponseEntity.created(uri).body(categories);
		}
		
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<CategoryDTO> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		

}
