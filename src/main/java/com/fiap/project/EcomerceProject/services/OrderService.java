package com.fiap.project.EcomerceProject.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.project.EcomerceProject.dto.OrderDTO;
import com.fiap.project.EcomerceProject.entities.Order;
import com.fiap.project.EcomerceProject.enums.OrderStatus;
import com.fiap.project.EcomerceProject.repositories.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	
	public List<OrderDTO> findAll(){
		List<Order> orders = repository.findAll();
		List<OrderDTO> orderDTO = new ArrayList<>();
		//O ": clients" indica que estamos percorrendo cada elemento da lista clients 
		//que e armazenado na variavel clientsFull que e usada como parametro na ClientsDTO 
		//com o conteudo para a copyToDTO.
		//Pode ser lido, para cada Clients nomeado clientsFull na lista clients faça o codigo abaixo.
		for(Order ordersFull : orders) {
			OrderDTO dto = copyToDTO(ordersFull);
		     orderDTO.add(dto);
		}
		return orderDTO;
		
	}
	
	public OrderDTO findById(Long id) {
		Optional<Order> order = repository.findById(id);
		Order orders = order.orElseThrow(() -> new  EntityNotFoundException("Order "+ id + "does not exist"));
		return new OrderDTO(orders);
				
	}
	
	public OrderDTO insert(OrderDTO orderDTO) {
		Order orders = copyFromDTO(orderDTO);
		orders = repository.save(orders);
		return new OrderDTO(orders);
	}
	
	public OrderDTO update(Long id, OrderDTO orderDto) {
		Order order = repository.getReferenceById(id);
		order = copyFromDTO(orderDto);
		repository.save(order);
		return new OrderDTO(order);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	private OrderDTO copyToDTO(Order orders) {
		OrderDTO dto = new OrderDTO();
		dto.setId(orders.getId());
		dto.setMoment(Instant.now());
		dto.setClient(orders.getClient());
		dto.setProducts(orders.getProducts());
		dto.setOrderStatus(OrderStatus.WAITING_PAYMENT);
		return dto;
		
	}	
	
	private Order copyFromDTO(OrderDTO orderDTO) {
		Order order = new Order();
	    order.setId(orderDTO.getId());
		order.setMoment(Instant.now());
		order.setClient(orderDTO.getClient());
		order.setProducts(orderDTO.getProducts());
		order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
		return order;
		
	}	

}
