package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NivelAcesso;

@Repository
public interface NivelAcessoRepo extends JpaRepository<NivelAcesso, Integer> {
    // Interface do Repositório para a classe NivelAcesso
    
}
