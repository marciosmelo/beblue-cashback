package com.beblue.cashback.model.enums;

public enum GeneroEnum {

    POP("POP"),
    MPB("MPB"),
    CLASSIC("CLASSIC"),
    ROCK("ROCK");

    private String descricao;


    GeneroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
