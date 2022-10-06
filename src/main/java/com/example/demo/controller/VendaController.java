package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Venda;
import com.example.demo.repo.ClienteRepo;
import com.example.demo.repo.ProdutoRepo;
import com.example.demo.repo.VendaRepo;

@Controller
public class VendaController {
    
    @Autowired
    VendaRepo vendaRepo;
    
    @Autowired
    ClienteRepo clienteRepo;
    
    @Autowired
    ProdutoRepo produtoRepo;
    
    // Listar
    @GetMapping("/venda")
    public String listarVendas(Model modelo) {
        modelo.addAttribute("listaVendas", vendaRepo.findAll());
        
        return "venda";
    }
    
    // Iniciar formulário vazio
    @GetMapping("/cadastroVenda")
    public String novaVenda(Model modelo) {
        Venda venda = new Venda();
        
        modelo.addAttribute("listaClientes", clienteRepo.findAll());
        modelo.addAttribute("listaProdutos", produtoRepo.findAll());
        modelo.addAttribute("venda", venda);
        
        return "formVenda";
    }
    
    // Salvar (Criar)
    @PostMapping("/salvarVenda")
    public String salvar(@ModelAttribute("venda") Venda venda, Model modelo) {
        vendaRepo.save(venda);
        modelo.addAttribute("listaVendas", vendaRepo.findAll());
        
        return "redirect:venda";
    }
    
    // Deletar
    @GetMapping("/deletarVenda/{id}")
    public String deletarVenda(@PathVariable("id") Integer id, Model modelo) {
        Venda venda = vendaRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esta venda não existe: " + id));
        
        vendaRepo.delete(venda);
        modelo.addAttribute("listaVendas", vendaRepo.findAll());
        
        return "redirect:/venda";
    }
    
}
