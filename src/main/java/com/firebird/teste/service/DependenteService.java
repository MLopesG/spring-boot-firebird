package com.firebird.teste.service;
import java.util.List;

import com.firebird.teste.model.DependenteModel;
import com.firebird.teste.repository.DepedenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependenteService {
    
    @Autowired
    private DepedenteRepository repository;

    public List<DependenteModel> clientesDependentesAll(Integer contrato) {
        return repository.findCadastros(contrato);
    }
}