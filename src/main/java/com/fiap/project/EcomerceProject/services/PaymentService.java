package com.fiap.project.EcomerceProject.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.project.EcomerceProject.dto.ClientsDTO;
import com.fiap.project.EcomerceProject.dto.OrderDTO;
import com.fiap.project.EcomerceProject.dto.PaymentDTO;
import com.fiap.project.EcomerceProject.entities.CreditCard;
import com.fiap.project.EcomerceProject.entities.Order;
import com.fiap.project.EcomerceProject.entities.Payment;
import com.fiap.project.EcomerceProject.enums.OrderStatus;
import com.fiap.project.EcomerceProject.repositories.OrderRepository;
import com.fiap.project.EcomerceProject.repositories.PaymnetRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentService {
	
	@Autowired
	private PaymnetRepository repository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	

	
	public PaymentDTO findById(Long id) {
		Optional<Payment> payment = repository.findById(id);
		Payment payments = payment.orElseThrow(() -> new  EntityNotFoundException("Payment "+ id + "does not exist"));
		return new PaymentDTO(payments);
				
	}
	
	public PaymentDTO insert(Long id, CreditCard creditCard) {
		Payment payment = new Payment();
		Optional<Order> order = orderRepository.findById(id);
		Order orders = order.orElseThrow(() -> new  EntityNotFoundException("Order "+ id + "does not exist"));		
		payment.setTotalValue(orders, creditCard.getCode());
		payment.setMoment(Instant.now());
		if(creditCard.equals(null)) {
			throw new IllegalArgumentException("Invalid Credit card, payment wasnt done ");
		}
		orders.setOrderStatus(OrderStatus.PAID);
		orderRepository.save(orders);
		return new PaymentDTO(payment);
	}
	

}
