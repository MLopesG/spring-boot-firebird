package com.firebird.teste.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cliente
 */
@Entity
@Table(name="cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private long idcliente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer contrato;

    @Column(nullable = false)
    private String cpf_cnpj;
    
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<DependenteModel> dependente;


    public ClienteModel() {
    }

    public ClienteModel(long idcliente, String nome, Integer contrato, String cpf_cnpj, List<DependenteModel> dependente) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.contrato = contrato;
        this.cpf_cnpj = cpf_cnpj;
        this.dependente = dependente;
    }

    public long getIdcliente() {
        return this.idcliente;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getContrato() {
        return this.contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public String getCpf_cnpj() {
        return this.cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public List<DependenteModel> getDependente() {
        return this.dependente;
    }

    public void setDependente(List<DependenteModel> dependente) {
        this.dependente = dependente;
    }
  }