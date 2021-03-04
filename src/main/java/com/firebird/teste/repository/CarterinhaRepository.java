package com.firebird.teste.repository;

import com.firebird.teste.model.CarterinhaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarterinhaRepository extends JpaRepository<CarterinhaModel, String> {
    @Query(value= "SELECT 'PET' AS tipo , c.idcliente,c.contrato,c.nome AS titular,                    d.nome,c.cpf_cnpj,rc.descricao AS raca,e.descricao AS especie,d.altura,d.peso,d.cor,                    (SELECT First(1) pc.data_vencimento FROM parcelas_cliente pc                    WHERE pc.cliente_id=c.idcliente AND pc.data_pagamento IS NOT NULL                    ORDER BY pc.data_vencimento DESC , pc.data_pagamento DESC) AS ult_mes_ref_pg,                    ((Extract(day FROM (SELECT First(1) pc.data_vencimento FROM parcelas_cliente pc                    WHERE pc.cliente_id=c.idcliente AND pc.data_pagamento IS NOT NULL                    ORDER BY pc.data_vencimento DESC , pc.data_pagamento DESC)))                    -Extract(day FROM CURRENT_DATE)                    ) AS dias_atraso,                    CASE                    WHEN ((Extract(day FROM (SELECT First(1) pc.data_vencimento FROM parcelas_cliente pc                    WHERE pc.cliente_id=c.idcliente AND pc.data_pagamento IS NOT NULL                    ORDER BY pc.data_vencimento DESC , pc.data_pagamento DESC)))                    -Extract(day FROM CURRENT_DATE)                    ) < 90 THEN 'ATIVO'                    ELSE 'INATIVO'                    END AS status,                    dateadd(-extract(day FROM dateadd(1 month TO CURRENT_DATE )) day TO dateadd(1 month TO CURRENT_DATE)) validade                    FROM dependente d                    LEFT JOIN cliente c ON c.idcliente=d.cliente_id                    LEFT JOIN raca_pet rc ON rc.raca_id=d.raca_id                    LEFT JOIN especie e ON e.especie_id=d.especie_id                    WHERE c.contrato = :contrato AND d.situacao=1                    AND c.situacao =1 AND d.tipo_dependente=2                ", nativeQuery = true)
    List<CarterinhaModel> findByContrato(Integer contrato);
}
