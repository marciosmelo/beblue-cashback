package com.beblue.cashback.service;

import com.beblue.cashback.model.Cashback;
import com.beblue.cashback.model.enums.DiaEnum;
import com.beblue.cashback.model.enums.GeneroEnum;
import com.beblue.cashback.repository.CashbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CashbackService {

    @Autowired
    private CashbackRepository repository;

    public Cashback obterCashbackDoDiaPorGenero(GeneroEnum genero) {
        DiaEnum dia = DiaEnum.values()[LocalDateTime.now().getDayOfWeek().ordinal()];
        return repository.findByGeneroAndDia(genero, dia);
    }
}
