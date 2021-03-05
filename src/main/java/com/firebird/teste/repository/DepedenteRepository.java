package com.firebird.teste.repository;

import java.util.List;

import com.firebird.teste.model.DependenteModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepedenteRepository extends JpaRepository<DependenteModel, Long> {
    @Query(value="select * from dependente d LEFT JOIN cliente c ON c.idcliente=d.cliente_id where c.situacao=1 and  c.contrato = :contrato", nativeQuery = true)
    List<DependenteModel> findCadastros(Integer contrato);
    
}