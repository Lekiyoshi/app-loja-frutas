package com.example.demo.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name = "usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresaId;
    @ManyToOne @JoinColumn(name = "nivel_acesso_id", referencedColumnName = "id")
    private NivelAcesso nivelAcessoId;
    private String nome;
    private String conta;
    private String senha;
    private String rg;
    private String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_nascimento") @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    private String telefone;
    private String email;
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Empresa getEmpresaId() {
        return empresaId;
    }
    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }
    public NivelAcesso getNivelAcessoId() {
        return nivelAcessoId;
    }
    public void setNivelAcessoId(NivelAcesso nivelAcessoId) {
        this.nivelAcessoId = nivelAcessoId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
