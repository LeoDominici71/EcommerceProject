package com.fiap.project.EcomerceProject.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fiap.project.EcomerceProject.entities.Clients;
import com.fiap.project.EcomerceProject.entities.Order;
import com.fiap.project.EcomerceProject.entities.Payment;
import com.fiap.project.EcomerceProject.entities.Products;
import com.fiap.project.EcomerceProject.enums.OrderStatus;

import jakarta.persistence.OneToMany;

public class OrderDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private Clients client;
	private List<Products> products = new ArrayList<>();
	private OrderStatus orderStatus;

	
	public OrderDTO(Order order) {
		this.id = order.getId();
		this.moment = order.getMoment();
		this.client = order.getClient();
	}

	public OrderDTO() {
		super();
	}

	public OrderDTO(Instant moment, Clients client) {
		super();
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	
	
	

}
