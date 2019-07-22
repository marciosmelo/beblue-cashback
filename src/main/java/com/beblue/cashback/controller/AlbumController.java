package com.beblue.cashback.controller;

import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.service.AlbumService;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class AlbumController {

    Logger logger = LoggerFactory.getLogger(AlbumController.class);

    private static final String NUMERO_PADRAO_PAGINA = "1";

    @Autowired
    private AlbumService service;

    @RequestMapping("/albuns")
    public Stream<AlbumSimplified> obterAlbunsPorGenero(@RequestParam Optional<String> genero, @RequestParam Optional<String> pagina) throws Exception {

        String numeroPagina = pagina.isPresent() ? pagina.get() : NUMERO_PADRAO_PAGINA;

        if (!genero.isPresent()) {
            throw new ApiException("Não é possível pesquisar Albuns sem informar um gênero");
        }

        String descricaoGenero = genero.get();
        logger.info("Pesquisando Albums do gênero {} na paginação de número {} ", descricaoGenero, numeroPagina);
        return service.obterAlbunsPorGenero(descricaoGenero, numeroPagina);
    }

    @RequestMapping("/albuns/{id}")
    public Album obterAlbumPorId(@PathVariable String id) throws ApiException {

        logger.info("Buscando Álbum de id {} ", id);
        return service.obterAlbumPorId(id);

    }

}
