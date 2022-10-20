package com.example.demo.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name = "fornecedor")
public class Fornecedor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    private String proprietario;
    private String responsavel;
    private String telefone;
    private String email;
    private String cep;
    private String logradouro;
    @Column(name = "numero_endereco")
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_informacao") @Temporal(TemporalType.DATE)
    private Calendar dataInformacao;
    @OneToMany(mappedBy = "fornecedor")
    private Set<Produto> produtos;
    @OneToMany(mappedBy = "fornecedor")
    private Set<Compra> compras;
    
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
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getProprietario() {
        return proprietario;
    }
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    public String getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
    public Calendar getDataInformacao() {
        return dataInformacao;
    }
    public void setDataInformacao(Calendar dataInformacao) {
        this.dataInformacao = dataInformacao;
    }
    public Set<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
    public Set<Compra> getCompras() {
        return compras;
    }
    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }
    
}
