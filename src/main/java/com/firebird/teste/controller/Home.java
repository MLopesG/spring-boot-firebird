package com.firebird.teste.controller;

import com.firebird.teste.service.CarterinhaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Home{

    @Autowired
    private CarterinhaService service;

    @GetMapping("/{contrato}")
    public ResponseEntity<?> getAll(@PathVariable(value = "contrato") Integer contrato) {
        return ResponseEntity.ok(service.carterinhasAssociado(contrato));
    }
}