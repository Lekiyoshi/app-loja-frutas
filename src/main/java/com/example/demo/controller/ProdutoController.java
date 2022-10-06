package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Produto;
import com.example.demo.repo.EmpresaRepo;
import com.example.demo.repo.FornecedorRepo;
import com.example.demo.repo.ProdutoRepo;

@Controller
public class ProdutoController {
    
    @Autowired
    ProdutoRepo produtoRepo;
    
    @Autowired
    EmpresaRepo empresaRepo;
    
    @Autowired
    FornecedorRepo fornecedorRepo;
    
    // Listar
    @GetMapping("/produto")
    public String listarProdutos(Model modelo) {
        modelo.addAttribute("listaProdutos", produtoRepo.findAll());
        
        return "produto";
    }
    
    // Iniciar formulário vazio
    @GetMapping("/cadastroProduto")
    public String novoProduto(Model modelo) {
        Produto produto = new Produto();
        
        modelo.addAttribute("listaEmpresas", empresaRepo.findAll());
        modelo.addAttribute("listaFornecedores", fornecedorRepo.findAll());
        modelo.addAttribute("produto", produto);
        
        return "formProduto";
    }
    
    // Salvar (Criar ou Atualizar)
    @PostMapping("/salvarProduto")
    public String salvar(@ModelAttribute("produto") Produto produto, Model modelo) {
        produtoRepo.save(produto);
        modelo.addAttribute("listaProdutos", produtoRepo.findAll());
        
        return "redirect:produto";
    }
    
    // Iniciar formulário com dados existentes
    @GetMapping("/alterarProduto/{id}")
    public String alterarProduto(@PathVariable("id") Integer id, Model modelo) {
        Produto produto = produtoRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este produto não existe: " + id));
        
        modelo.addAttribute("listaEmpresas", empresaRepo.findAll());
        modelo.addAttribute("listaFornecedores", fornecedorRepo.findAll());
        modelo.addAttribute("produto", produto);
        
        return "formProduto";
    }
    
    // Deletar
    @GetMapping("/deletarProduto/{id}")
    public String deletarProduto(@PathVariable("id") Integer id, Model modelo) {
        Produto produto = produtoRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este produto não existe: " + id));
        
        produtoRepo.delete(produto);
        modelo.addAttribute("listaProdutos", produtoRepo.findAll());
        
        return "redirect:/produto";
    }

}
