package com.fiap.project.EcomerceProject.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fiap.project.EcomerceProject.entities.Category;
import com.fiap.project.EcomerceProject.entities.Products;

public class CategoryDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private List<Products> products = new ArrayList<>();
	
	public CategoryDTO(String name, List<Products> products) {
		super();
		this.name = name;
		this.products = products;
	}

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.products = category.getProducts();
	}

	public CategoryDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	
	
	
	


}
