package com.vivasnathaly.examen2.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "divisas")
public class CuentaDivisaExtranjera {

    @Id
    private String id;
    private String tipoDivisa;
    @NotNull
    private String accountNumber;
    private String clientId;
    private BigDecimal saldo;
    @NotEmpty
    private List<String> movimeintos;

}
