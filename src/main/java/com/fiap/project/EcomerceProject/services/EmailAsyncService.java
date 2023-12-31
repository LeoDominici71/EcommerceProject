package com.fiap.project.EcomerceProject.services;


import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fiap.project.EcomerceProject.entities.Clients;
@Service
public class EmailAsyncService {

	@Autowired
	private JavaMailSender sender;
	
	@Async
	public void emailSender(Clients client) {
		 try {
		int randomInRange = ThreadLocalRandom.current().nextInt(100);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ecommercextpo@gmail.com");
		message.setTo(client.getEmail());
		message.setSubject("Code");
		message.setText("Your code is : " + randomInRange);
		
		sender.send(message);
		 } catch (MailException ex) {
			 System.out.println(ex.getMessage());
		 }
	}
		 

}