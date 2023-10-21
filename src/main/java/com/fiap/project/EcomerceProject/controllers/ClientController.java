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
import com.fiap.project.EcomerceProject.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientsDTO>> findAll(){
		List<ClientsDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientsDTO> findById(@PathVariable Long id){
		ClientsDTO clients = service.findById(id);
		return ResponseEntity.ok().body(clients);
	}

	@PostMapping
	public ResponseEntity<ClientsDTO> insert(@RequestBody ClientsDTO clients){

		clients = service.insert(clients);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clients.getId()).toUri();
        return ResponseEntity.created(uri).body(clients);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientsDTO> update(@PathVariable Long id, @RequestBody ClientsDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientsDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}