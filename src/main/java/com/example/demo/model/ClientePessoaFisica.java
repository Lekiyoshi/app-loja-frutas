package com.example.demo.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name = "cliente_pessoa_fisica")
public class ClientePessoaFisica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente clienteId;
    private String rg;
    private String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_nascimento") @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getClienteId() {
        return clienteId;
    }
    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Calendar getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}