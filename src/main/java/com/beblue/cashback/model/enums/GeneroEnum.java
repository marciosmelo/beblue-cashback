package com.beblue.cashback.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneroEnum {

    POP(1,"POP"),
    MPB(2, "MPB"),
    CLASSIC(3,"CLASSIC"),
    ROCK(4,"ROCK");

    private int codigo;
    private String descricao;

}
