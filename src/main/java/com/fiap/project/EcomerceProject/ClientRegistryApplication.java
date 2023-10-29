package com.fiap.project.EcomerceProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ClientRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRegistryApplication.class, args);
	}

}
