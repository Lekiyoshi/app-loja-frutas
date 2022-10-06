package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Empresa;

@Repository
public interface EmpresaRepo extends JpaRepository<Empresa, Integer> {
    // Interface do Repositório para a classe Empresa
}
