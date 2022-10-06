package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Compra;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
    // Interface do Repositório para a classe Compra
    
}
