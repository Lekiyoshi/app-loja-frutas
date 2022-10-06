package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repo.NivelAcessoRepo;

@Controller
public class NivelAcessoController {
    
    @Autowired
    NivelAcessoRepo nivelAcessoRepo;
    
    // Listar
    @GetMapping("/nivelAcesso")
    public String listarNiveisDeAcesso(Model modelo) {
        modelo.addAttribute("listaNiveisDeAcesso", nivelAcessoRepo.findAll());
        
        return "nivelAcesso";
    }

}
