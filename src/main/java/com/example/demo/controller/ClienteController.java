package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.datatransfer.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.model.ClientePessoaFisica;
import com.example.demo.model.ClientePessoaJuridica;
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
        ClienteDTO clienteDto = new ClienteDTO();
        
        modelo.addAttribute("cliente", clienteDto);
        modelo.addAttribute("inicioTipoCliente", 0);
        
        return "formCliente";
    }
    
    // Salvar (Criar ou Atualizar)
    @Transactional
    @PostMapping("/salvarCliente")
    public String salvar(@ModelAttribute("cliente") ClienteDTO clienteDto, Model modelo) {
        // Mapear de ClienteDTO para Cliente
        Cliente cliente = new Cliente(
                clienteDto.getClienteId(),
                clienteDto.getNome(),
                clienteDto.getTelefone(),
                clienteDto.getEmail(),
                clienteDto.getCep(),
                clienteDto.getLogradouro(),
                clienteDto.getNumeroEndereco(),
                clienteDto.getBairro(),
                clienteDto.getCidade(),
                clienteDto.getUf(),
                clienteDto.getTipoCliente());
        
        clienteRepo.save(cliente);
        
        if (cliente.getId() == null) {
            // Obter o id do Cliente, se ainda não é conhecido
            cliente.setId(clienteRepo.obterMaxId().get(0));
        }
        
        if (clienteDto.getTipoCliente() == 0) {  // Se pessoa física
            // Mapear de ClienteDTO para ClientePessoaFisica
            ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica(
                    clienteDto.getClientePessoaFisicaId(),
                    cliente,
                    clienteDto.getRg(),
                    clienteDto.getCpf(),
                    clienteDto.getDataNascimento());

            clientePessoaFisicaRepo.save(clientePessoaFisica);
            
        } else if (clienteDto.getTipoCliente() == 1) {  // Se pessoa jurídica
            // Mapear de ClienteDTO para ClientePessoaJuridica
            ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica(
                    clienteDto.getClientePessoaJuridicaId(),
                    cliente,
                    clienteDto.getCnpj(),
                    clienteDto.getInscricaoEstadual(),
                    clienteDto.getProprietario(),
                    clienteDto.getRepresentante(),
                    clienteDto.getRamoAtividade());

            clientePessoaJuridicaRepo.save(clientePessoaJuridica);
            
        } else {
            // Criar tratamento de excessão aqui
        }
        
        modelo.addAttribute("listaClientesPessoaFisica", clientePessoaFisicaRepo.findAll());
        modelo.addAttribute("listaClientesPessoaJuridica", clientePessoaJuridicaRepo.findAll());
        
        return "redirect:cliente";
    }

    // Iniciar formulário com dados existentes (pessoa física)
    @GetMapping("/alterarClientePessoaFisica/{id}")
    public String alterarClientePessoaFisica(@PathVariable("id") Integer id, Model modelo) {
        ClientePessoaFisica clientePessoaFisica = clientePessoaFisicaRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente (pessoa física) não existe: " + id));
        
        Integer clienteId = clientePessoaFisica.getCliente().getId();
        
        Cliente cliente = clienteRepo
                .findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + clienteId));
        
        ClienteDTO clienteDto = new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getCep(),
                cliente.getLogradouro(),
                cliente.getNumeroEndereco(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getUf(),
                cliente.getTipoCliente(),
                clientePessoaFisica.getId(),
                clientePessoaFisica.getRg(),
                clientePessoaFisica.getCpf(),
                clientePessoaFisica.getDataNascimento());
        
        modelo.addAttribute("cliente", clienteDto);
        modelo.addAttribute("inicioTipoCliente", 0);
        
        return "formCliente";
    }
    
    // Iniciar formulário com dados existentes (pessoa jurídica)
    @GetMapping("/alterarClientePessoaJuridica/{id}")
    public String alterarClientePessoaJuridica(@PathVariable("id") Integer id, Model modelo) {
        ClientePessoaJuridica clientePessoaJuridica = clientePessoaJuridicaRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente (pessoa jurídica) não existe: " + id));
        
        Integer clienteId = clientePessoaJuridica.getCliente().getId();
        
        Cliente cliente = clienteRepo
                .findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + clienteId));
        
        ClienteDTO clienteDto = new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getCep(),
                cliente.getLogradouro(),
                cliente.getNumeroEndereco(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getUf(),
                cliente.getTipoCliente(),
                clientePessoaJuridica.getId(),
                clientePessoaJuridica.getCnpj(),
                clientePessoaJuridica.getInscricaoEstadual(),
                clientePessoaJuridica.getProprietario(),
                clientePessoaJuridica.getRepresentante(),
                clientePessoaJuridica.getRamoAtividade());
        
        modelo.addAttribute("cliente", clienteDto);
        modelo.addAttribute("inicioTipoCliente", 1);
        
        return "formCliente";
    }

    // Deletar ClientePessoaFisica e Cliente associado
    @GetMapping("/deletarClientePessoaFisica/{id}")
    public String deletarClientePessoaFisica(@PathVariable("id") Integer id, Model modelo) {
        ClientePessoaFisica clientePessoaFisica = clientePessoaFisicaRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente (pessoa física) não existe: " + id));
        
        Integer clienteId = clientePessoaFisica.getCliente().getId();
        
        Cliente cliente = clienteRepo
                .findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + clienteId));
        
        clientePessoaFisicaRepo.delete(clientePessoaFisica);
        clienteRepo.delete(cliente);
        modelo.addAttribute("listaClientes", clienteRepo.findAll());
        
        return "redirect:/cliente";
    }
    
    // Deletar ClientePessoaJuridica e Cliente associado
    @GetMapping("/deletarClientePessoaJuridica/{id}")
    public String deletarClientePessoaJuridica(@PathVariable("id") Integer id, Model modelo) {
        ClientePessoaJuridica clientePessoaJuridica = clientePessoaJuridicaRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente (pessoa jurídica) não existe: " + id));
        
        Integer clienteId = clientePessoaJuridica.getCliente().getId();
        
        Cliente cliente = clienteRepo
                .findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + clienteId));
        
        clientePessoaJuridicaRepo.delete(clientePessoaJuridica);
        clienteRepo.delete(cliente);
        
        modelo.addAttribute("listaClientesPessoaFisica", clientePessoaFisicaRepo.findAll());
        modelo.addAttribute("listaClientesPessoaJuridica", clientePessoaJuridicaRepo.findAll());
        
        return "redirect:/cliente";
    }


}
