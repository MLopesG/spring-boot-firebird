package com.firebird.teste.controller;

import com.firebird.teste.service.CarterinhaPetService;
import com.firebird.teste.service.ClienteService;
import com.firebird.teste.service.DependenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home{

    @Autowired
    private CarterinhaPetService service;

    @Autowired 
    private DependenteService serviceDependentes;
    
    @Autowired 
    private ClienteService serviceCliente;

    @GetMapping("/pet/{contrato}")
    public ResponseEntity<?> getAll(@PathVariable(value = "contrato") Integer contrato) {
        return ResponseEntity.ok(service.carterinhasAssociado(contrato));
    }

    @GetMapping("/dependentes/{contrato}")
    public ResponseEntity<?> listarDependentes(@PathVariable(value = "contrato") Integer contrato) {
        return ResponseEntity.ok(serviceDependentes.clientesDependentesAll(contrato));
    }

    @GetMapping("/associado/{contrato}")
    public ResponseEntity<?> infoAssociados(@PathVariable(value = "contrato") Integer contrato) {
        return ResponseEntity.ok(serviceCliente.clientesDependentesAll(contrato));
    }
}