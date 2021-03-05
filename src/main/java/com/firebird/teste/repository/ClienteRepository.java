package com.firebird.teste.repository;

import java.util.List;

import com.firebird.teste.model.ClienteModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    @Query(value="select FIRST 10 * from cliente where situacao=1 and contrato = :contrato", nativeQuery = true)
    List<ClienteModel> findCadastros(Integer contrato);
}