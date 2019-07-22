package com.beblue.cashback.common;

import java.math.BigDecimal;

public class ValorUtil {

    public static BigDecimal gerarValorRandomico(int range) {
        BigDecimal max = new BigDecimal(range*30);
        BigDecimal randFromDouble = BigDecimal.valueOf(Math.random());
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec
                .setScale(2, BigDecimal.ROUND_DOWN);
        return actualRandomDec;
    }
}
