package com.fiap.project.EcomerceProject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.project.EcomerceProject.dto.ClientsDTO;
import com.fiap.project.EcomerceProject.entities.Clients;
import com.fiap.project.EcomerceProject.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private EmailAsyncService service;
	
	public List<ClientsDTO> findAll(){
		List<Clients> clients = repository.findAll();
		List<ClientsDTO> clientsDTO = new ArrayList<>();
		//O ": clients" indica que estamos percorrendo cada elemento da lista clients 
		//que e armazenado na variavel clientsFull que e usada como parametro na ClientsDTO 
		//com o conteudo para a copyToDTO.
		//Pode ser lido, para cada Clients nomeado clientsFull na lista clients faça o codigo abaixo.
		for(Clients clientsFull : clients) {
			ClientsDTO dto = copyToDTO(clientsFull);
			clientsDTO.add(dto);
		}
		
		return clientsDTO;
		
	}
	
	public ClientsDTO findById(Long id) {
		Optional<Clients> client = 	repository.findById(id);
		Clients clients = client.orElseThrow(() -> new  EntityNotFoundException("Client "+ id + "does not exist"));
		return new ClientsDTO(clients);
				
	}
	
	public ClientsDTO insert(ClientsDTO client) {
		Clients clients = copyFromDTO(client);
		clients = repository.save(clients);
		this.service.emailSender(clients);
		return new ClientsDTO(clients);
	}
	
	public ClientsDTO update(Long id, ClientsDTO clientDto) {
		Clients entity = repository.getReferenceById(id);
		entity = copyFromDTO(clientDto);
		repository.save(entity);
		return new ClientsDTO(entity);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	private ClientsDTO copyToDTO(Clients clients) {
		ClientsDTO dto = new ClientsDTO();
		dto.setId(clients.getId());
		dto.setName(clients.getName());
		dto.setEmail(clients.getEmail());
		dto.setStreet(clients.getStreet());
		dto.setState(clients.getState());
		dto.setPostalCode(clients.getPostalCode());
		dto.setCity(clients.getCity());
		return dto;
		
	}	
	
	private Clients copyFromDTO(ClientsDTO clients) {
		Clients dto = new Clients();
		dto.setId(clients.getId());
		dto.setName(clients.getName());
		dto.setEmail(clients.getEmail());
		dto.setStreet(clients.getStreet());
		dto.setState(clients.getState());
		dto.setPostalCode(clients.getPostalCode());
		dto.setCity(clients.getCity());
		return dto;
		
	}	

}
