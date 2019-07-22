package com.beblue.cashback.service;

import com.beblue.cashback.model.Cashback;
import com.beblue.cashback.model.enums.GeneroEnum;

public interface CashbackService {

    Cashback obterCashbackPorGeneroDia(GeneroEnum genero, int codigoDia);
}
