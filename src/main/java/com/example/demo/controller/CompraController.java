package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Compra;
import com.example.demo.repo.CompraRepo;
import com.example.demo.repo.FornecedorRepo;
import com.example.demo.repo.ProdutoRepo;

@Controller
public class CompraController {
    
    @Autowired
    CompraRepo compraRepo;
    
    @Autowired
    FornecedorRepo fornecedorRepo;
    
    @Autowired
    ProdutoRepo produtoRepo;
    
    // Listar
    @GetMapping("/compra")
    public String listarCompras(Model modelo) {
        modelo.addAttribute("listaCompras", compraRepo.findAll());
        
        return "compra";
    }
    
    // Iniciar formulário vazio
    @GetMapping("/cadastroCompra")
    public String novaCompra(Model modelo) {
        Compra compra = new Compra();
        
        modelo.addAttribute("listaFornecedores", fornecedorRepo.findAll());
        modelo.addAttribute("listaProdutos", produtoRepo.findAll());
        modelo.addAttribute("compra", compra);
        
        return "formCompra";
    }
    
    // Salvar (Criar)
    @PostMapping("/salvarCompra")
    public String salvar(@ModelAttribute("compra") Compra compra, Model modelo) {
        compraRepo.save(compra);
        modelo.addAttribute("listaCompras", compraRepo.findAll());
        
        return "redirect:compra";
    }
    
    // Deletar
    @GetMapping("/deletarCompra/{id}")
    public String deletarCompra(@PathVariable("id") Integer id, Model modelo) {
        Compra compra = compraRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esta compra não existe: " + id));
        
        compraRepo.delete(compra);
        modelo.addAttribute("listaCompras", compraRepo.findAll());
        
        return "redirect:/compra";
    }
    
}
