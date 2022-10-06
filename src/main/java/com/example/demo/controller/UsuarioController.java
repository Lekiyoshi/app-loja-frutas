package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Usuario;
import com.example.demo.repo.EmpresaRepo;
import com.example.demo.repo.NivelAcessoRepo;
import com.example.demo.repo.UsuarioRepo;

@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioRepo usuarioRepo;
    
    @Autowired
    EmpresaRepo empresaRepo;
    
    @Autowired
    NivelAcessoRepo nivelAcessoRepo;
    
    // Listar
    @GetMapping("/usuario")
    public String listarUsuarios(Model modelo) {
        modelo.addAttribute("listaUsuarios", usuarioRepo.findAll());
        
        return "usuario";
    }
    
    // Iniciar formulário vazio
    @GetMapping("/cadastroUsuario")
    public String novoUsuario(Model modelo) {
        Usuario usuario = new Usuario();
        
        modelo.addAttribute("listaEmpresas", empresaRepo.findAll());
        modelo.addAttribute("listaNiveisDeAcesso", nivelAcessoRepo.findAll());
        modelo.addAttribute("usuario", usuario);
        
        return "formUsuario";
    }
    
    // Salvar (Criar ou Atualizar)
    @PostMapping("/salvarUsuario")
    public String salvar(@ModelAttribute("usuario") Usuario usuario, Model modelo) {
        usuarioRepo.save(usuario);
        modelo.addAttribute("listaUsuarios", usuarioRepo.findAll());
        
        return "redirect:usuario";
    }
    
    // Iniciar formulário com dados existentes
    @GetMapping("/alterarUsuario/{id}")
    public String alterarUsuario(@PathVariable("id") Integer id, Model modelo) {
        Usuario usuario = usuarioRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este usuario não existe: " + id));
        
        modelo.addAttribute("listaEmpresas", empresaRepo.findAll());
        modelo.addAttribute("listaNiveisDeAcesso", nivelAcessoRepo.findAll());
        modelo.addAttribute("usuario", usuario);
        
        return "formUsuario";
    }
    
    // Deletar
    @GetMapping("/deletarUsuario/{id}")
    public String deletarUsuario(@PathVariable("id") Integer id, Model modelo) {
        Usuario usuario = usuarioRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este usuario não existe: " + id));
        
        usuarioRepo.delete(usuario);
        modelo.addAttribute("listaUsuarios", usuarioRepo.findAll());
        
        return "redirect:/usuario";
    }

}
