package com.example.desafio_ibm.repository;


import com.example.desafio_ibm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
