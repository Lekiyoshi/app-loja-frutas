package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    // Interface do Repositório para a classe Cliente
    
    // Obter o último id adicionado
    @Query(value = "SELECT MAX(id) FROM Cliente")
    List<Integer> obterMaxId();
    
}
