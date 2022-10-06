package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Fornecedor;
import com.example.demo.repo.FornecedorRepo;

@Controller
public class FornecedorController {
    
    @Autowired
    FornecedorRepo fornecedorRepo;
    
    // Listar
    @GetMapping("/fornecedor")
    public String abreFornecedor(Model modelo) {
        modelo.addAttribute("listaFornecedores", fornecedorRepo.findAll());
        
        return "fornecedor";
    }
    
    // Iniciar formulário vazio
    @GetMapping("/cadastroFornecedor")
    public String novoFornecedor(Model modelo) {
        Fornecedor fornecedor = new Fornecedor();
        
        modelo.addAttribute("fornecedor", fornecedor);
        
        return "formFornecedor";
    }
    
    // Salvar (Criar ou Atualizar)
    @PostMapping("/salvarFornecedor")
    public String salvar(@ModelAttribute("fornecedor") Fornecedor fornecedor, Model modelo) {
        fornecedorRepo.save(fornecedor);
        modelo.addAttribute("listaFornecedores", fornecedorRepo.findAll());
        
        return "redirect:fornecedor";
    }
    
    // Iniciar formulário com dados existentes
    @GetMapping("/alterarFornecedor/{id}")
    public String alterarFornecedor(@PathVariable("id") Integer id, Model modelo) {
        Fornecedor fornecedor = fornecedorRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este fornecedor não existe: " + id));
        
        modelo.addAttribute("fornecedor", fornecedor);
        
        return "formFornecedor";
    }
    
    // Deletar
    @GetMapping("/deletarFornecedor/{id}")
    public String deletarFornecedor(@PathVariable("id") Integer id, Model modelo) {
        Fornecedor fornecedor = fornecedorRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este fornecedor não existe: " + id));
        
        fornecedorRepo.delete(fornecedor);
        modelo.addAttribute("listaFornecedores", fornecedorRepo.findAll());
        
        return "redirect:/fornecedor";
    }
    
}
