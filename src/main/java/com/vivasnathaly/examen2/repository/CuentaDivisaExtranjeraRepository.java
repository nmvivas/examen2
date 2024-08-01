package com.vivasnathaly.examen2.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.vivasnathaly.examen2.model.CuentaDivisaExtranjera;

public interface CuentaDivisaExtranjeraRepository extends MongoRepository<CuentaDivisaExtranjera, String> {
    List<CuentaDivisaExtranjera> findByClientId(String clientId);

    CuentaDivisaExtranjera findByAccountNumber(String accountNumber);

    CuentaDivisaExtranjera findByTipoDivisa(String tipoDivisa);
}
