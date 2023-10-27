package com.fiap.project.EcomerceProject.dto;

import java.io.Serializable;

import com.fiap.project.EcomerceProject.entities.Clients;
import com.fiap.project.EcomerceProject.entities.CreditCard;

import jakarta.annotation.Nullable;

public class CreditCardDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String cardNumber;
	private String nameOnCard;
	private String expirationDate;
	private String cvv;
	private String brand;
	private Clients client;
	@Nullable
	private String code;

	public CreditCardDTO(String cardNumber, String nameOnCard, String expirationDate, String cvv, String brand,
			Clients client) {
		super();
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.brand = brand;
		this.client = client;
	}

	public CreditCardDTO(CreditCard credit) {
		this.id = credit.getId();
		this.cardNumber = credit.getCardNumber();
		this.nameOnCard = credit.getNameOnCard();
		this.expirationDate = credit.getExpirationDate();
		this.cvv = credit.getCvv();
		this.brand = credit.getBrand();
		this.client = credit.getClient();

	}

	public CreditCardDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
