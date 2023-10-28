package com.fiap.project.EcomerceProject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_payments")
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	private Double totalValue;
	
	private CreditCard creditCard;
	
	private Order orders;

	public Payment() {
		super();
	}

	public Payment(Instant moment, Order orders) {
		super();
		this.moment = moment;
		this.orders = orders;
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
	

	public Order getOrder() {
		return orders;
	}

	public void setOrder(Order orders) {
		this.orders = orders;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Order orders, String code) {
		List<Products> products = orders.getProducts();
		double somaPreco = 0;
		for(Products productsSum : products) {
			somaPreco += productsSum.getPrice();
		}
		
		this.totalValue = somaPreco;
		
		if(!code.equals(null)) {
			int discount = 95/100;
			this.totalValue = this.totalValue * discount;
		}
		
	}
	

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", moment=" + moment + "]";
	}

}
