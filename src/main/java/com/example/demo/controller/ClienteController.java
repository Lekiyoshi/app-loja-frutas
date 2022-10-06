package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cliente;
import com.example.demo.repo.ClientePessoaFisicaRepo;
import com.example.demo.repo.ClientePessoaJuridicaRepo;
import com.example.demo.repo.ClienteRepo;

@Controller
public class ClienteController {
    
    @Autowired
    ClienteRepo clienteRepo;
    
    @Autowired
    ClientePessoaFisicaRepo clientePessoaFisicaRepo;
    
    @Autowired
    ClientePessoaJuridicaRepo clientePessoaJuridicaRepo;
    
    // Listar
    @GetMapping("/cliente")
    public String listarClientes(Model modelo) {
        modelo.addAttribute("listaClientesPessoaFisica", clientePessoaFisicaRepo.findAll());
        modelo.addAttribute("listaClientesPessoaJuridica", clientePessoaJuridicaRepo.findAll());
        
        return "cliente";
    }
    
    // Iniciar formulário vazio
    @GetMapping("/cadastroCliente")
    public String novoCliente(Model modelo) {
        Cliente cliente = new Cliente();
        
        modelo.addAttribute("cliente", cliente);
        
        return "formCliente";
    }
    
    // Salvar (Criar ou Atualizar)
    @PostMapping("/salvarCliente")
    public String salvar(@ModelAttribute("cliente") Cliente cliente, Model modelo) {
        clienteRepo.save(cliente);
        modelo.addAttribute("listaClientes", clienteRepo.findAll());
        
        return "redirect:cliente";
    }
    
    // Iniciar formulário com dados existentes
    @GetMapping("/alterarCliente/{id}")
    public String alterarCliente(@PathVariable("id") Integer id, Model modelo) {
        Cliente cliente = clienteRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + id));
        
        modelo.addAttribute("cliente", cliente);
        
        return "formCliente";
    }
    
    // Deletar
    @GetMapping("/deletarCliente/{id}")
    public String deletarCliente(@PathVariable("id") Integer id, Model modelo) {
        Cliente cliente = clienteRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + id));
        
        clienteRepo.delete(cliente);
        modelo.addAttribute("listaClientes", clienteRepo.findAll());
        
        return "redirect:/cliente";
    }

}
