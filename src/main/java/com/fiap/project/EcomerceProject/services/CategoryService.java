package com.fiap.project.EcomerceProject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiap.project.EcomerceProject.dto.CategoryDTO;
import com.fiap.project.EcomerceProject.entities.Category;
import com.fiap.project.EcomerceProject.repositories.CategoryRepository;

public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findAll(){
		List<Category> category = repository.findAll();
		List<CategoryDTO> categoryDTO = new ArrayList<>();
		//O ": clients" indica que estamos percorrendo cada elemento da lista clients 
		//que e armazenado na variavel clientsFull que e usada como parametro na ClientsDTO 
		//com o conteudo para a copyToDTO.
		//Pode ser lido, para cada Clients nomeado clientsFull na lista clients faça o codigo abaixo.
		for(Category categoryFull : category) {
			CategoryDTO dto = copyToDTO(categoryFull);
			categoryDTO.add(dto);
		}
		
		return categoryDTO;
		
	}
	
	public CategoryDTO insert(CategoryDTO category) {
		Category categories = copyFromDTO(category);
		categories = repository.save(categories);
		return new CategoryDTO(categories);
	}
	
	
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	private CategoryDTO copyToDTO(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		dto.setProducts(category.getProducts());
		
		return dto;
		
	}	
	
	private Category copyFromDTO(CategoryDTO category) {
		Category dto = new Category();
		dto.setId(category.getId());
		dto.setName(category.getName());
		dto.setProducts(category.getProducts());
		return dto;
		
	}	

}
