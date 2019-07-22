package com.beblue.cashback.service;

import com.beblue.cashback.exception.ApiException;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;

import java.util.stream.Stream;

public interface AlbumService {

    Stream<AlbumSimplified> obterAlbunsPorGenero(String descricaoGenero, String pagina) throws ApiException;
    Album obterAlbumPorId(String id) throws ApiException;
}
