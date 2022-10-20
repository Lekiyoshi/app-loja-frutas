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

@Entity @Table(name = "venda")
public class Venda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
    @ManyToOne @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;
    private Integer quantidade;
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @Column(name = "forma_pagamento")
    private Integer formaPagamento;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_venda") @Temporal(TemporalType.DATE)
    private Calendar dataVenda;
    
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
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public Integer getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public Calendar getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

}
