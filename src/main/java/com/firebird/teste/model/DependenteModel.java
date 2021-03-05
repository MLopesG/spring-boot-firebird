package com.firebird.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Cliente
 */
@Entity
@Table(name="dependente")
public class DependenteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dependente_id")
    private long dependente_id;

    @Column(nullable = false)
    private String nome;     

    public DependenteModel() {
    }

    public DependenteModel(long dependente_id, String nome) {
        this.dependente_id = dependente_id;
        this.nome = nome;
    }

    public long getDependente_id() {
        return this.dependente_id;
    }

    public void setDependente_id(long dependente_id) {
        this.dependente_id = dependente_id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}