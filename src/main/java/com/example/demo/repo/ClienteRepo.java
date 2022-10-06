package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    // Interface do Repositório para a classe Cliente
    
}
