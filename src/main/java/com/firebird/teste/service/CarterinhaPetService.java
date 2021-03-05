package com.firebird.teste.service;

import java.util.List;

import com.firebird.teste.model.CarterinhaPetModel;
import com.firebird.teste.repository.CarterinhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarterinhaPetService {
    
    @Autowired
    private CarterinhaRepository repository;

    public List<CarterinhaPetModel> carterinhasAssociado(Integer id) {
        return  repository.findByContrato(id);
    }
}