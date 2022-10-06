package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Produto;

@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Integer> {
    // Interface do Repositório para a classe Produto
    
}
