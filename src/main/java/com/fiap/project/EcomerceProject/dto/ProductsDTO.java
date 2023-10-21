package com.fiap.project.EcomerceProject.dto;

import java.io.Serializable;

import com.fiap.project.EcomerceProject.entities.Category;
import com.fiap.project.EcomerceProject.entities.Products;

public class ProductsDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String name;

	private String description;

	private Double price;
	
	private Category categories;

	public ProductsDTO(String name, String description, Double price, Category categories) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
	}

	public ProductsDTO(Products products) {
		this.id = products.getId();
		this.name = products.getName();
		this.description = products.getDescription();
		this.price = products.getPrice();
        this.categories = products .getCategories(); 
	}

	public ProductsDTO() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}
	
	
	
	


}
