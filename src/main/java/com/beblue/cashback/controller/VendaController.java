package com.beblue.cashback.controller;

import com.beblue.cashback.common.Messages;
import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;
import com.beblue.cashback.model.Venda;
import com.beblue.cashback.service.VendaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    Logger logger = LoggerFactory.getLogger(VendaController.class);

    private static final String NUMERO_PADRAO_PAGINA = "1";

    @Autowired
    private VendaService service;

    @Autowired
    Messages messages;

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

}
