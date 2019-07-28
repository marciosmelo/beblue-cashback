package com.beblue.cashback.controller;

import com.beblue.cashback.common.Messages;
import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;
import com.beblue.cashback.model.Venda;
import com.beblue.cashback.service.VendaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    Logger logger = LoggerFactory.getLogger(VendaController.class);

    @Autowired
    private VendaService service;

    @GetMapping("/{id}")
    public Venda obterVendaPorId(@PathVariable Long id) throws ApiException {
        logger.info("Buscando Venda por identificador {} ", id);
        return service.obterPorId(id);
    }

    @PostMapping()
    public Venda registrarVenda(@RequestBody @Valid List<Disco> discos) throws ApiException {
        logger.info("Registrando Vendas dos Discos ");
        return service.registrarVenda(discos);
    }

    @GetMapping()
    public List<Venda> consultarVendas() throws ApiException {
        logger.info("Consultando todas Vendas de Discos ");

            return service.obterVendas();
    }
}


