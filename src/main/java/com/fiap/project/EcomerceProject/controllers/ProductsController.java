package com.fiap.project.EcomerceProject.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.project.EcomerceProject.dto.ClientsDTO;
import com.fiap.project.EcomerceProject.dto.ProductsDTO;
import com.fiap.project.EcomerceProject.services.ProductsService;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {
	
	@Autowired
	private ProductsService service;
	

	
	@GetMapping
	public ResponseEntity<List<ProductsDTO>> findAll(){
		List<ProductsDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductsDTO> findById(@PathVariable Long id){
		ProductsDTO products = service.findById(id);
		return ResponseEntity.ok().body(products);
	}

	@PostMapping
	public ResponseEntity<ProductsDTO> insert(@RequestBody ProductsDTO products){

		products = service.insert(products);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(products.getId()).toUri();
        return ResponseEntity.created(uri).body(products);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductsDTO> update(@PathVariable Long id, @RequestBody ProductsDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProductsDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
