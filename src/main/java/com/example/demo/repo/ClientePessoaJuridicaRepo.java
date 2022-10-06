package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ClientePessoaJuridica;

@Repository
public interface ClientePessoaJuridicaRepo extends JpaRepository<ClientePessoaJuridica, Integer> {
    // Interface do Repositório para a classe ClientePessoaJuridica
    
}
