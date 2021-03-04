package com.firebird.teste.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.firebird.teste.model.CarterinhaModel;
import com.firebird.teste.repository.CarterinhaRepository;

import org.springframework.stereotype.Service;

@Service
public class CarterinhaService {

    private CarterinhaRepository repository;

    CarterinhaService(CarterinhaRepository repo) {
        this.repository = repo;
    }

    public Map<String, Object> carterinhasAssociado(Integer id) {
        List<CarterinhaModel> registros = repository.findByContrato(id);
        Map<String, Object> result = new HashMap<>();

        try {
            result.put("associados", registros);
            result.put("success", true);
            result.put("message", "");
        } catch (Exception error) {
            result.put("success", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}