package com.fiap.project.EcomerceProject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_clients")
public class Clients implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String street;

	private String state;

	private String postalCode;

	private String city;
	
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	private List<CreditCard> creditCard = new ArrayList<>();

	

	public Clients() {
		super();
	}

	public Clients(String name, String email, String street, String state, String postalCode, String city) {
		super();
		this.name = name;
		this.email = email;
		this.street = street;
		this.state = state;
		this.postalCode = postalCode;
		this.city = city;
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

	public List<CreditCard> getCreditCard() {
		return creditCard;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + ", name=" + name + ", email=" + email + ", street=" + street + ", state=" + state
				+ ", postalCode=" + postalCode + ", city=" + city + ", orders=" + orders + ", creditCard="
				+ "]";
	}

	

}
