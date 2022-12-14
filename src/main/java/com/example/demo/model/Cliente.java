package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "cliente")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String cep;
    private String logradouro;
    @Column(name = "numero_endereco")
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    @Column(name = "tipo_cliente")
    private Integer tipoCliente;
    @OneToMany(mappedBy = "cliente")
    private Set<Venda> vendas;
    
    // Construtores
    public Cliente() {
        super();
    }
    public Cliente(Integer id, String nome, String telefone, String email, String cep, String logradouro,
            String numeroEndereco, String bairro, String cidade, String uf, Integer tipoCliente) {
        super();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.tipoCliente = tipoCliente;
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumeroEndereco() {
        return numeroEndereco;
    }
    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public Integer getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Set<Venda> getVendas() {
        return vendas;
    }
    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }
    
}
