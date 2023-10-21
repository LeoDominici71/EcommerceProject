package com.fiap.project.EcomerceProject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiap.project.EcomerceProject.dto.ProductsDTO;
import com.fiap.project.EcomerceProject.entities.Products;
import com.fiap.project.EcomerceProject.repositories.ProductsRepository;

import jakarta.persistence.EntityNotFoundException;

public class ProductsService {
	
	@Autowired
	private ProductsRepository repository;
	
	
	public List<ProductsDTO> findAll(){
		List<Products> products = repository.findAll();
		List<ProductsDTO> productsDTO = new ArrayList<>();
		
		for(Products productsFull : products) {
			ProductsDTO dto = copyToDTO(productsFull);

			productsDTO.add(dto);
		}
		
		return productsDTO;
	}
	
	public ProductsDTO findById(Long id) {
		Products products = repository.findById(id).orElseThrow(() -> new  EntityNotFoundException("Product id " + id + "does not exits"));
		return new ProductsDTO(products);
		
	}
	
	public ProductsDTO insert(ProductsDTO products) {
		Products productsFull = copyFromDTO(products);
		repository.save(productsFull);
		return new ProductsDTO(productsFull);
	}
	
	public ProductsDTO update(Long id, ProductsDTO products) {
		Products productsId = repository.findById(id).orElseThrow(() -> new  EntityNotFoundException("Product id " + id + "does not exits"));
		productsId = copyFromDTO(products);
		repository.save(productsId);
		return new ProductsDTO(productsId);

	}
	
	public void delete(Long id) {
		repository.deleteById(id);
		
	}



private ProductsDTO copyToDTO(Products products) {
	ProductsDTO dto = new ProductsDTO();
	dto.setId(products.getId());
	dto.setName(products.getName());
	dto.setDescription(products.getDescription());
	dto.setPrice(products.getPrice());
	return dto;
	
}	

private Products copyFromDTO(ProductsDTO dto) {
	Products products = new Products();
	products.setId(dto.getId());
	products.setName(dto.getName());
	products.setDescription(dto.getDescription());
	products.setPrice(dto.getPrice());
	return products;
	
}	

}