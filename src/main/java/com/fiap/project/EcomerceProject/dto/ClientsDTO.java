package com.fiap.project.EcomerceProject.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fiap.project.EcomerceProject.entities.Clients;
import com.fiap.project.EcomerceProject.entities.CreditCard;
import com.fiap.project.EcomerceProject.entities.Order;

public class ClientsDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private Long id;

	private String name;

	private String email;

	private String street;

	private String state;

	private String postalCode;

	private String city;
	
	private List<Order> orders = new ArrayList<>();
	
	private List<CreditCard> creditCard = new ArrayList<>();
	
	

	public ClientsDTO() {
		super();
	}
	
	public ClientsDTO(Clients entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.street = entity.getStreet();
		this.state = entity.getState();
		this.postalCode = entity.getPostalCode();
		this.city = entity.getCity();
		this.orders = entity.getOrders();
		this.creditCard = entity.getCreditCard();
		
		
	}



	public ClientsDTO(String name, String email, String street, String state, String postalCode, String city,
			List<Order> orders, List<CreditCard> creditCard) {
		super();
		this.name = name;
		this.email = email;
		this.street = street;
		this.state = state;
		this.postalCode = postalCode;
		this.city = city;
		this.orders = orders;
		this.creditCard = creditCard;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public List<Order> getOrders() {
		return orders;
	}



	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	public List<CreditCard> getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}
	
	

	
	


}
