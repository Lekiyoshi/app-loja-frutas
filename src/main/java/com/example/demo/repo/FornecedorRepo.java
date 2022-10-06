package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Fornecedor;

@Repository
public interface FornecedorRepo extends JpaRepository<Fornecedor, Integer> {
    // Interface do Repositório para a classe Fornecedor
    
}
