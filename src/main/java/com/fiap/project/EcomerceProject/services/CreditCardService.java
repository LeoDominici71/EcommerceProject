package com.fiap.project.EcomerceProject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.project.EcomerceProject.dto.ClientsDTO;
import com.fiap.project.EcomerceProject.dto.CreditCardDTO;
import com.fiap.project.EcomerceProject.entities.Clients;
import com.fiap.project.EcomerceProject.entities.CreditCard;
import com.fiap.project.EcomerceProject.repositories.CreditCardRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CreditCardService {
	
	@Autowired
	private CreditCardRepository repository;
	
	public List<CreditCardDTO> findAll(){
		List<CreditCard> creditCard = repository.findAll();
		List<CreditCardDTO> creditCardDTO = new ArrayList<>();
		//O ": clients" indica que estamos percorrendo cada elemento da lista clients 
		//que e armazenado na variavel clientsFull que e usada como parametro na ClientsDTO 
		//com o conteudo para a copyToDTO.
		//Pode ser lido, para cada Clients nomeado clientsFull na lista clients faça o codigo abaixo.
		for(CreditCard creditCardFull : creditCard) {
			CreditCardDTO dto = copyToDTO(creditCardFull);
			creditCardDTO.add(dto);
		}
		return creditCardDTO;
		
	}
	
	public CreditCardDTO findById(Long id) {
		Optional<CreditCard> creditCard = 	repository.findById(id);
		CreditCard creditCards = creditCard.orElseThrow(() -> new  EntityNotFoundException("Client "+ id + "does not exist"));
		return new CreditCardDTO(creditCards);
				
	}
	
	public CreditCardDTO insert(CreditCardDTO creditCardDTO) {
		CreditCard creditCard = copyFromDTO(creditCardDTO);
		creditCard = repository.save(creditCard);
		return new CreditCardDTO(creditCard);
	}
	
	public CreditCardDTO update(Long id, CreditCardDTO creditCardDTO) {
		CreditCard creditCard = repository.getReferenceById(id);
		copyFromDTOUpdate(creditCardDTO, creditCard);
		repository.save(creditCard);
		return new CreditCardDTO(creditCard);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	private CreditCardDTO copyToDTO(CreditCard creditCard) {
		CreditCardDTO dto = new CreditCardDTO();
		dto.setId(creditCard.getId());
		dto.setCardNumber(creditCard.getCardNumber());
		dto.setNameOnCard(creditCard.getNameOnCard());
		dto.setExpirationDate(creditCard.getExpirationDate());
		dto.setCvv(creditCard.getCvv());
		dto.setBrand(creditCard.getBrand());
		dto.setCode(creditCard.getCode());
		return dto;
		
	}	
	
	private CreditCard copyFromDTO(CreditCardDTO creditCard) {
		CreditCard dto = new CreditCard();
		dto.setId(creditCard.getId());
		dto.setCardNumber(creditCard.getCardNumber());
		dto.setNameOnCard(creditCard.getNameOnCard());
		dto.setExpirationDate(creditCard.getExpirationDate());
		dto.setCvv(creditCard.getCvv());
		dto.setBrand(creditCard.getBrand());
		dto.setCode(creditCard.getCode());
		return dto;
		
	}	
	
	private void copyFromDTOUpdate(CreditCardDTO dto, CreditCard entity) {
		entity.setCardNumber(dto.getCardNumber());
		entity.setNameOnCard(dto.getNameOnCard());
		entity.setExpirationDate(dto.getExpirationDate());
		entity.setCvv(dto.getCvv());
		entity.setBrand(dto.getBrand());
		entity.setCode(dto.getCode());
		
	}	



}
