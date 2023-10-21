package com.fiap.project.EcomerceProject.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.project.EcomerceProject.dto.PaymentDTO;
import com.fiap.project.EcomerceProject.entities.CreditCard;
import com.fiap.project.EcomerceProject.entities.Payment;
import com.fiap.project.EcomerceProject.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PaymentDTO> findById(@PathVariable Long id){
		PaymentDTO payment = service.findById(id);
		return ResponseEntity.ok().body(payment);
	}
	
	@PostMapping
	public ResponseEntity<PaymentDTO> insert(@PathVariable Long id, @RequestBody CreditCard creditCard){
        PaymentDTO payment = new PaymentDTO();
		payment = service.insert(id, creditCard);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(uri).body(payment);
	}

}
