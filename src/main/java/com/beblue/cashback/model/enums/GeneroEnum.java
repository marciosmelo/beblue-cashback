package com.beblue.cashback.model.enums;

public enum GeneroEnum {

    POP(1,"POP"),
    MPB(2, "MPB"),
    CLASSIC(3,"CLASSIC"),
    ROCK(4,"ROCK");

    private int codigo;
    private String descricao;


    GeneroEnum(int codigo, String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() { return  codigo; }
}
