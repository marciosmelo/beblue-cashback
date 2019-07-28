package com.beblue.cashback.model;

import com.beblue.cashback.model.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class AlbumVendido {

    private String nome;
    private GeneroEnum genero;
    private BigDecimal valor;
    private BigDecimal cashback;
}
