package com.beblue.cashback.service;

import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;

import java.util.List;

public interface AlbumService {

    List<Disco> obterAlbunsPorGenero(String descricaoGenero, String pagina) throws ApiException;
    Disco obterAlbumPorId(String id) throws ApiException;
}
