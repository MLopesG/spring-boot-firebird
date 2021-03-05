package com.firebird.teste.service;
import java.util.List;

import com.firebird.teste.model.ClienteModel;
import com.firebird.teste.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteModel> clientesDependentesAll(Integer contrato) {
        return repository.findCadastros(contrato);
    }
}