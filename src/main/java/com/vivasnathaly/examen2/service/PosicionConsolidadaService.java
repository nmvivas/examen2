package com.vivasnathaly.examen2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.vivasnathaly.examen2.model.CuentaDivisaExtranjera;
import com.vivasnathaly.examen2.repository.CuentaDivisaExtranjeraRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PosicionConsolidadaService {

    private CuentaDivisaExtranjeraRepository cuentaDivisaExtranjeraRepository;

    public PosicionConsolidadaService(CuentaDivisaExtranjeraRepository cuentaDivisaExtranjeraRepository) {
        this.cuentaDivisaExtranjeraRepository = cuentaDivisaExtranjeraRepository;
    }	

    public List<CuentaDivisaExtranjera> getCuentasByClientId(String clientId) {
        return cuentaDivisaExtranjeraRepository.findByClientId(clientId);
    }

    private CuentaDivisaExtranjera create(String accountNumber) {
        log.debug("Going to search cuenta divisa: {}", accountNumber);
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/v1/registros")
                .build();

        CuentaDivisaExtranjera movimiento = restClient.get()
                .uri("/create/{accountNumber}", accountNumber)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(CuentaDivisaExtranjera.class);
        if (accountNumber != null) {
  

            return null;
        } else {
            return null;
        }

    }

    

    
    


}
