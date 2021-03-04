package com.firebird.teste.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.firebird.teste.model.CarterinhaModel;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarterinhaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    private RowMapper<CarterinhaModel> allMapper() {
        return new RowMapper<CarterinhaModel>() {
            @Override
            public CarterinhaModel mapRow(ResultSet resultSet, int i) throws SQLException {
                String tipo= resultSet.getString("tipo");
                Integer idcliente= resultSet.getInt("idcliente");
                Integer contrato= resultSet.getInt("contrato");
                String titular= resultSet.getString("titular");
                String nome= resultSet.getString("nome");
                String cpf_cnpj= resultSet.getString("cpf_cnpj");
                String raca= resultSet.getString("raca");
                String especie= resultSet.getString("especie");
                String altura= resultSet.getString("altura");
                String peso= resultSet.getString("peso");
                String cor= resultSet.getString("cor");
                String ult_mes_ref_pg= resultSet.getString("ult_mes_ref_pg");
                Integer dias_atraso= resultSet.getInt("dias_atraso");
                String status= resultSet.getString("status");
                String validade= resultSet.getString("validade");
                return new CarterinhaModel(tipo, idcliente, contrato, titular, nome, cpf_cnpj, raca, especie, altura, peso, cor, ult_mes_ref_pg, dias_atraso, status, validade);
            };
        };
    }

    private List<CarterinhaModel> carterinhasAssociadoSQL(Integer id) {
        String sql = "SELECT 'PET' AS tipo , c.idcliente,c.contrato,c.nome AS titular,                    d.nome,c.cpf_cnpj,rc.descricao AS raca,e.descricao AS especie,d.altura,d.peso,d.cor,                    (SELECT First(1) pc.data_vencimento FROM parcelas_cliente pc                    WHERE pc.cliente_id=c.idcliente AND pc.data_pagamento IS NOT NULL                    ORDER BY pc.data_vencimento DESC , pc.data_pagamento DESC) AS ult_mes_ref_pg,                    ((Extract(day FROM (SELECT First(1) pc.data_vencimento FROM parcelas_cliente pc                    WHERE pc.cliente_id=c.idcliente AND pc.data_pagamento IS NOT NULL                    ORDER BY pc.data_vencimento DESC , pc.data_pagamento DESC)))                    -Extract(day FROM CURRENT_DATE)                    ) AS dias_atraso,                    CASE                    WHEN ((Extract(day FROM (SELECT First(1) pc.data_vencimento FROM parcelas_cliente pc                    WHERE pc.cliente_id=c.idcliente AND pc.data_pagamento IS NOT NULL                    ORDER BY pc.data_vencimento DESC , pc.data_pagamento DESC)))                    -Extract(day FROM CURRENT_DATE)                    ) < 90 THEN 'ATIVO'                    ELSE 'INATIVO'                    END AS status,                    dateadd(-extract(day FROM dateadd(1 month TO CURRENT_DATE )) day TO dateadd(1 month TO CURRENT_DATE)) validade                    FROM dependente d                    LEFT JOIN cliente c ON c.idcliente=d.cliente_id                    LEFT JOIN raca_pet rc ON rc.raca_id=d.raca_id                    LEFT JOIN especie e ON e.especie_id=d.especie_id                    WHERE c.contrato = ? AND d.situacao=1                    AND c.situacao =1 AND d.tipo_dependente=2                ";

        return jdbcTemplate.query(sql, new Object[] { id }, allMapper());
    }


    public Map<String, Object> carterinhasAssociado(Integer id) {
        List<CarterinhaModel> registros = carterinhasAssociadoSQL(id);
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