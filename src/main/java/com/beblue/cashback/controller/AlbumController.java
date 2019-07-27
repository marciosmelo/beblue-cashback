package com.beblue.cashback.controller;

import com.beblue.cashback.common.Messages;
import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;
import com.beblue.cashback.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {

    Logger logger = LoggerFactory.getLogger(AlbumController.class);

    private static final String NUMERO_PADRAO_PAGINA = "1";

    @Autowired
    private AlbumService service;

    @Autowired
    Messages messages;

    @RequestMapping("/albuns")
    public List<Disco> obterAlbunsPorGenero(@RequestParam Optional<String> genero, @RequestParam Optional<String> pagina) throws ApiException {

        String numeroPagina = pagina.isPresent() ? pagina.get() : NUMERO_PADRAO_PAGINA;

        if (!genero.isPresent()) {
            throw new ApiException(messages.get("erro.genero.nao.informado"));
        }

        String descricaoGenero = genero.get();
        logger.info("Pesquisando Albums do gênero {} na paginação de número {} ", descricaoGenero, numeroPagina);
        return service.obterAlbunsPorGenero(descricaoGenero, numeroPagina);
    }

    @RequestMapping("/albuns/{id}")
    public Disco obterAlbumPorId(@PathVariable String id) throws ApiException {

        logger.info("Buscando Álbum de id {} ", id);
        return service.obterAlbumPorId(id);

    }

}
