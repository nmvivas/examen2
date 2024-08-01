package com.vivasnathaly.examen2.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Request {

    private String monedaOrigen; 
    private String monedaDestino;
    private BigDecimal montoCompra;


}
