package com.fiap.project.EcomerceProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.project.EcomerceProject.entities.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long>{

}
