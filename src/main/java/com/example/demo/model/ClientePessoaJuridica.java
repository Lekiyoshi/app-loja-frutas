package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "cliente_pessoa_juridica")
public class ClientePessoaJuridica implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
    private String cnpj;
    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;
    private String proprietario;
    private String representante;
    @Column(name = "ramo_atividade")
    private String ramoAtividade;
    
    // Construtores
    public ClientePessoaJuridica() {
        super();
    }
    public ClientePessoaJuridica(Integer id, Cliente cliente, String cnpj, String inscricaoEstadual,
            String proprietario, String representante, String ramoAtividade) {
        super();
        this.id = id;
        this.cliente = cliente;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.proprietario = proprietario;
        this.representante = representante;
        this.ramoAtividade = ramoAtividade;
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
