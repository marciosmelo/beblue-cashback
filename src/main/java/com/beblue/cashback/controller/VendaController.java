package com.beblue.cashback.controller;

import com.beblue.cashback.common.Messages;
import com.beblue.cashback.model.Cashback;
import com.beblue.cashback.model.enums.GeneroEnum;
import com.beblue.cashback.service.CashbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    Logger logger = LoggerFactory.getLogger(VendaController.class);

    private static final String NUMERO_PADRAO_PAGINA = "1";

    @Autowired
    private CashbackService service;

    @Autowired
    Messages messages;

    @RequestMapping("/cashback")
    public Cashback obterCashbackPorGeneroDia() {
        return service.obterCashbackPorGeneroDia(GeneroEnum.POP, DayOfWeek.MONDAY.getValue());
    }
}
