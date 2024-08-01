package com.vivasnathaly.examen2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivasnathaly.examen2.model.CuentaDivisaExtranjera;
import com.vivasnathaly.examen2.service.PosicionConsolidadaService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class PosicionConsolidadaController {

    private PosicionConsolidadaService posicionConsolidadaService;

    @GetMapping("/cliente/{clientId}")
    public List<CuentaDivisaExtranjera> getCuentasByClientId(@PathVariable String clientId) {
        return posicionConsolidadaService.getCuentasByClientId(clientId);
    }

}
