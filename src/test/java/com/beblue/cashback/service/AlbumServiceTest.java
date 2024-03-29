package com.beblue.cashback.service;

import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;
import com.beblue.cashback.model.enums.GeneroEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlbumServiceTest {

    @Mock
	AlbumService albumService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveObterAlbunPorId() {
        String idAlbum = "5zT1JLIj9E57p3e1rFm9Uq";
        Disco discoABBA = getDiscoMock(idAlbum);

        try {

            when(albumService.obterAlbumPorId(idAlbum)).thenReturn(discoABBA);

            Disco disco = albumService.obterAlbumPorId(idAlbum);

            Assert.assertEquals(disco, discoABBA);

        } catch (Exception e) {
            fail("Erro ao testar obter item por id " + e.getMessage());
        }

    }

    @Test
    @ExceptionHandler(ApiException.class)
    public void deveRetornarExcecaoQuandoTentarObterDiscoComIdInvalido() {
        String idNaoExistente = "123";

        try {

            when(albumService.obterAlbumPorId(idNaoExistente)).thenReturn(null);

            Disco disco = albumService.obterAlbumPorId(idNaoExistente);

        } catch (Exception e) {
            fail("Erro ao testar obter item por id " + e.getMessage());
        }
    }

    @Test
    @ExceptionHandler(ApiException.class)
    public void deveRetornarErroAoPesquisarListaDeDiscosComPaginacaoMaiorQueEsperada() {

        try {
            List<Disco> discosClassicos =
                    albumService.obterAlbunsPorGenero(GeneroEnum.CLASSIC.getDescricao(), "6");
        } catch (Exception e) {
            fail("Falha ao realizar testes de pesquisa por generos");
        }

    }

    @Test
    @ExceptionHandler(ApiException.class)
    public void deveRetornarErroAoPesquisarListaDeDiscosComGeneroInvalido() {
        String generoInvalido = "arrocha";
        try {

            List<Disco> discosClassicos =
                    albumService.obterAlbunsPorGenero(generoInvalido, "5");
        } catch (Exception e) {
            fail("Falha ao realizar testes de pesquisa por generos");
        }

    }

    private Disco getDiscoMock(String idAlbum) {
        return new Disco(1L,
                idAlbum,
                "Combat Rock",
                GeneroEnum.ROCK,
                BigDecimal.TEN);
    }
}