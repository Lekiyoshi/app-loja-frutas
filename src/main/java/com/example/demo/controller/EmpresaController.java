package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Empresa;
import com.example.demo.repo.EmpresaRepo;

@Controller
public class EmpresaController {
    
    @Autowired
    EmpresaRepo empresaRepo;
    
    // Listar
    @GetMapping("/empresa")
    public String abreEmpresa(Model modelo) {
        modelo.addAttribute("listaEmpresas", empresaRepo.findAll());
        
        return "empresa";
    }
    
    // Iniciar formulário vazio
    @GetMapping("/cadastroEmpresa")
    public String novaEmpresa(Model modelo) {
        Empresa empresa = new Empresa();
        
        modelo.addAttribute("empresa", empresa);
        
        return "formEmpresa";
    }
    
    // Salvar (Criar ou Atualizar)
    @PostMapping("/salvarEmpresa")
    public String salvar(@ModelAttribute("empresa") Empresa empresa, Model modelo) {
        empresaRepo.save(empresa);
        modelo.addAttribute("listaEmpresas", empresaRepo.findAll());
        
        return "redirect:empresa";
    }
    
    // Iniciar formulário com dados existentes
    @GetMapping("/alterarEmpresa/{id}")
    public String alterarEmpresa(@PathVariable("id") Integer id, Model modelo) {
        Empresa empresa = empresaRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esta empresa não existe: " + id));
        
        modelo.addAttribute("empresa", empresa);
        
        return "formEmpresa";
    }
    
    // Deletar
    @GetMapping("/deletarEmpresa/{id}")
    public String deletarEmpresa(@PathVariable("id") Integer id, Model modelo) {
        Empresa empresa = empresaRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esta empresa não existe: " + id));
        
        empresaRepo.delete(empresa);
        modelo.addAttribute("listaEmpresas", empresaRepo.findAll());
        
        return "redirect:/empresa";
    }
    
}
