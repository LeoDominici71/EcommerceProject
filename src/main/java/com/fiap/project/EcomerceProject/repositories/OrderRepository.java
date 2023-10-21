package com.fiap.project.EcomerceProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.project.EcomerceProject.entities.Clients;
import com.fiap.project.EcomerceProject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
