package com.beblue.cashback.service;

import com.beblue.cashback.credentials.SpotifyApiCredentials;
import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.enums.GeneroEnum;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class AlbumServiceImpl implements AlbumService {

    private static final CountryCode BRASIL = CountryCode.BR;
    private static final Integer QUANTIDADE_ALBUNS_MAXIMO = 50;
    private static final Integer QUANTIDADE_ALBUNS_POR_PAGINA = 10;

    private static final SpotifyApi spotityApi = SpotifyApiCredentials.getSpotifyApi();

    @Override
    public Stream<AlbumSimplified> obterAlbunsPorGenero(String descricaGenero, String pagina) throws ApiException {
        Integer quantidadeAlbuns = QUANTIDADE_ALBUNS_MAXIMO;
        Integer inicioContagem = 0;

        try {

            GeneroEnum genero = this.obterGeneroPorDescricao(descricaGenero);

            if (!pagina.isEmpty()) {
                quantidadeAlbuns = QUANTIDADE_ALBUNS_POR_PAGINA;
                inicioContagem = obterInicioDaPaginacao(pagina);
            }

            final SearchAlbumsRequest searchAlbumsRequest = spotityApi.searchAlbums(genero.getDescricao())
                    .market(BRASIL)
                    .offset(inicioContagem)
                    .limit(quantidadeAlbuns)
                    .build();

            final Paging<AlbumSimplified> albumSimplifiedPaging = searchAlbumsRequest.execute();

            return Arrays.stream(albumSimplifiedPaging.getItems())
                    .filter(a -> a.getType().equals(ModelObjectType.ALBUM))
                    .sorted(Comparator.comparing(AlbumSimplified::getName));

        } catch (IOException | SpotifyWebApiException e) {
            throw new ApiException("Error: " + e.getMessage());
        }
    }

    @Override
    public Album obterAlbumPorId(String id) throws ApiException {

        try {

            final GetAlbumRequest albumRequest = spotityApi
                    .getAlbum(id)
                    .market(BRASIL).build();

            return albumRequest.execute();
        } catch (IOException | SpotifyWebApiException e) {
            throw new ApiException("Não existe nenhum album com identificador: " + id);
        }

    }

    private Integer obterInicioDaPaginacao(String pagina) throws ApiException {
        Integer numPagina = 0;
        Integer inicioContagem;
        try {
            numPagina = Integer.valueOf(pagina);

            if (numPagina < 1 || numPagina > 5) {
                throw new ApiException("Número de Página inválido (Min 1, Max 5).");
            }

            inicioContagem = (numPagina - 1) * QUANTIDADE_ALBUNS_POR_PAGINA;


        } catch (NumberFormatException ne) {
            throw new ApiException("Número da página é inválido, favor informar um valor inteiro");
        }
        return inicioContagem;
    }

    private GeneroEnum obterGeneroPorDescricao(String descricaGenero) throws ApiException {
        try {
            return GeneroEnum.valueOf(descricaGenero.toUpperCase());
        } catch (IllegalArgumentException ile) {
            throw new ApiException("Erro: Os Gêneros Musicais suportados são: Rock, MPB, Classic ou Pop.");
        }
    }
}
