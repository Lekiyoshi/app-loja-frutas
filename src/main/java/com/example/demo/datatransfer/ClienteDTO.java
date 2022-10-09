package com.example.demo.datatransfer;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class ClienteDTO {
    // Atributos da classe Cliente
    private Integer clienteId;
    private String nome;
    private String telefone;
    private String email;
    private String cep;
    private String logradouro;
    private String numeroEndereco;
    private String bairro;
    private String cidade;
    private String uf;
    private Integer tipoCliente;
    
    // Atributos da classe ClientePessoaFisica
    private Integer clientePessoaFisicaId;
    private String rg;
    private String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    
    // Atributos da classe ClientePessoaJuridica
    private Integer clientePessoaJuridicaId;
    private String cnpj;
    private String inscricaoEstadual;
    private String proprietario;
    private String representante;
    private String ramoAtividade;
    
    // Construtores
    public ClienteDTO() {
        super();
    }
    public ClienteDTO(Integer clienteId, String nome, String telefone, String email, String cep, String logradouro,
            String numeroEndereco, String bairro, String cidade, String uf, Integer tipoCliente,
            Integer clientePessoaFisicaId, String rg, String cpf, Calendar dataNascimento) {
        super();
        this.clienteId = clienteId;
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
        this.clientePessoaFisicaId = clientePessoaFisicaId;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    public ClienteDTO(Integer clienteId, String nome, String telefone, String email, String cep, String logradouro,
            String numeroEndereco, String bairro, String cidade, String uf, Integer tipoCliente,
            Integer clientePessoaJuridicaId, String cnpj, String inscricaoEstadual, String proprietario,
            String representante, String ramoAtividade) {
        super();
        this.clienteId = clienteId;
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
        this.clientePessoaJuridicaId = clientePessoaJuridicaId;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.proprietario = proprietario;
        this.representante = representante;
        this.ramoAtividade = ramoAtividade;
    }

    // Getters e Setters
    public Integer getClienteId() {
        return clienteId;
    }
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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
    public Integer getClientePessoaFisicaId() {
        return clientePessoaFisicaId;
    }
    public void setClientePessoaFisicaId(Integer clientePessoaFisicaId) {
        this.clientePessoaFisicaId = clientePessoaFisicaId;
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
    public Integer getClientePessoaJuridicaId() {
        return clientePessoaJuridicaId;
    }
    public void setClientePessoaJuridicaId(Integer clientePessoaJuridicaId) {
        this.clientePessoaJuridicaId = clientePessoaJuridicaId;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public String getProprietario() {
        return proprietario;
    }
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
    public String getRepresentante() {
        return representante;
    }
    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    public String getRamoAtividade() {
        return ramoAtividade;
    }
    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }
    
}
