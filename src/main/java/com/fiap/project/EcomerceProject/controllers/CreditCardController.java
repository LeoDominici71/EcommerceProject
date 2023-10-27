package com.fiap.project.EcomerceProject.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.project.EcomerceProject.dto.ClientsDTO;
import com.fiap.project.EcomerceProject.dto.CreditCardDTO;
import com.fiap.project.EcomerceProject.services.CreditCardService;

@RestController
@RequestMapping(value = "/creditCard")
public class CreditCardController {
	
	@Autowired
	private CreditCardService service;
	
	
	@GetMapping
	public ResponseEntity<List<CreditCardDTO>> findAll(){
		List<CreditCardDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CreditCardDTO> findById(@PathVariable Long id){
		CreditCardDTO creditCard = service.findById(id);
		return ResponseEntity.ok().body(creditCard);
	}

	@PostMapping
	public ResponseEntity<CreditCardDTO> insert(@RequestBody CreditCardDTO creditCard){

		creditCard = service.insert(creditCard);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creditCard.getId()).toUri();
        return ResponseEntity.created(uri).body(creditCard);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CreditCardDTO> update(@PathVariable Long id, @RequestBody CreditCardDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CreditCardDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
