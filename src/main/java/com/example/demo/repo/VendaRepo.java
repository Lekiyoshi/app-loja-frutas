package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Venda;

@Repository
public interface VendaRepo extends JpaRepository<Venda, Integer> {
    // Interface do Repositório para a classe Venda
    
}
