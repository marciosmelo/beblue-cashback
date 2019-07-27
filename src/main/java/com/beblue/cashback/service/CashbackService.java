package com.beblue.cashback.service;

import com.beblue.cashback.model.Cashback;
import com.beblue.cashback.model.enums.GeneroEnum;
import com.beblue.cashback.repository.CashbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashbackService {

    @Autowired
    private CashbackRepository repository;

}
