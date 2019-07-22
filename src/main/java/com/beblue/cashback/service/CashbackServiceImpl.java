package com.beblue.cashback.service;

import com.beblue.cashback.model.Cashback;
import com.beblue.cashback.model.enums.GeneroEnum;
import com.beblue.cashback.repository.CashbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashbackServiceImpl implements CashbackService {

    @Autowired
    private CashbackRepository repository;

    @Override
    public Cashback obterCashbackPorGeneroDia(GeneroEnum genero, int codigoDia) {
        Optional<Cashback> optionalCashback = repository.findById(Long.valueOf(codigoDia));

        return optionalCashback.get();
    }
}
