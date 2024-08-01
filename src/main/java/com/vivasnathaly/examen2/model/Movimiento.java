package com.vivasnathaly.examen2.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "movimientos")
public class Movimiento {

    @Id
    private String id;
    private LocalDateTime fecha;
    private String tipo;
    @NotNull
    private BigDecimal valor;
    private BigDecimal saldo;

}
