package com.vivasnathaly.examen2.service;

import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;

import com.vivasnathaly.examen2.model.CuentaDivisaExtranjera;
import com.vivasnathaly.examen2.model.Request;
import com.vivasnathaly.examen2.repository.CuentaDivisaExtranjeraRepository;

@Service
public class CompraMonedaService {
    private CuentaDivisaExtranjeraRepository cuentaDivisaExtranjeraService;

    public CompraMonedaService(CuentaDivisaExtranjeraRepository cuentaDivisaExtranjera) {
        this.cuentaDivisaExtranjeraService = cuentaDivisaExtranjera;
    }

    public void comprarMoneda(String accountNumber, String monedaOrigen, String monedaDestino, BigDecimal montoCompra) {
        CuentaDivisaExtranjera cuentaOrigen = cuentaDivisaExtranjeraService.findByAccountNumber(accountNumber);
        if (cuentaOrigen != null) {
            if (cuentaOrigen.getSaldo().compareTo(montoCompra) >= 0) {
                cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(montoCompra));
                cuentaDivisaExtranjeraService.save(cuentaOrigen);
                CuentaDivisaExtranjera cuentaDestino = cuentaDivisaExtranjeraService.findByTipoDivisa(monedaDestino);
                if (cuentaDestino != null) {
                    cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(montoCompra));
                    cuentaDivisaExtranjeraService.save(cuentaDestino);
                } else {
                    cuentaDestino = new CuentaDivisaExtranjera();
                    cuentaDestino.setAccountNumber(accountNumber);
                    cuentaDestino.setTipoDivisa(monedaDestino);
                    cuentaDestino.setSaldo(montoCompra);
                    cuentaDivisaExtranjeraService.save(cuentaDestino);
                }
            }
        }
    }

    private CuentaDivisaExtranjera cotizacion(String accountNumber) {
        log.debug("Going to search cuenta divisa: {}", accountNumber);
        RestClient restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/v1/cotizacion")
                .build();

        CuentaDivisaExtranjera movimiento = restClient.get()
                .uri("/create/{accountNumber}", accountNumber)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(CuentaDivisaExtranjera.class);
        if (accountNumber != null) {
        Request register = new RegisterBanquito();
            register.setMonedaOrigen(movimiento.get);


            return register;
        } else {
            return null;
        }
    }
}