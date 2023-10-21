package com.fiap.project.EcomerceProject.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fiap.project.EcomerceProject.entities.Order;
import com.fiap.project.EcomerceProject.entities.Payment;

public class PaymentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant moment;
	
	private Double totalValue;

	private Order order;
	
	public PaymentDTO() {
		super();
	}


	public PaymentDTO(Instant moment) {
		super();
		this.moment = moment;
	}


	public PaymentDTO(Payment payment) {
		this.id = payment.getId();
		this.moment = payment.getMoment();
		this.totalValue = payment.getTotalValue();
	}
	

	public PaymentDTO(Instant moment, Order order) {
		super();
		this.moment = moment;
		this.order = order;
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
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Double getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	
	
	

}
