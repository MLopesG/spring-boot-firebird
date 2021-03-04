package com.firebird.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarterinhaModel {
    private String tipo;
    @Id
    @Column(name = "idcliente")
    private Integer idcliente;
    private Integer contrato;
    private String titular;
    private String nome;
    private String cpf_cnpj;
    private String raca;
    private String especie;
    private String altura;
    private String peso;
    private String cor;
    private String ult_mes_ref_pg;
    private Integer dias_atraso;
    private String status; 
    private String validade;

    public CarterinhaModel() {
    }

    public CarterinhaModel(String tipo, Integer idcliente, Integer contrato, String titular, String nome, String cpf_cnpj, String raca, String especie, String altura, String peso, String cor, String ult_mes_ref_pg, Integer dias_atraso, String status, String validade) {
        this.tipo = tipo;
        this.idcliente = idcliente;
        this.contrato = contrato;
        this.titular = titular;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.raca = raca;
        this.especie = especie;
        this.altura = altura;
        this.peso = peso;
        this.cor = cor;
        this.ult_mes_ref_pg = ult_mes_ref_pg;
        this.dias_atraso = dias_atraso;
        this.status = status;
        this.validade = validade;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdcliente() {
        return this.idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getContrato() {
        return this.contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return this.cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getAltura() {
        return this.altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return this.peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getUlt_mes_ref_pg() {
        return this.ult_mes_ref_pg;
    }

    public void setUlt_mes_ref_pg(String ult_mes_ref_pg) {
        this.ult_mes_ref_pg = ult_mes_ref_pg;
    }

    public Integer getDias_atraso() {
        return this.dias_atraso;
    }

    public void setDias_atraso(Integer dias_atraso) {
        this.dias_atraso = dias_atraso;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidade() {
        return this.validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

  
  
}