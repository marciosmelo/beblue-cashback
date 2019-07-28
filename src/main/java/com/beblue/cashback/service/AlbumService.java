package com.beblue.cashback.service;

import com.beblue.cashback.common.Messages;
import com.beblue.cashback.common.ValorUtil;
import com.beblue.cashback.credentials.SpotifyApiCredentials;
import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AlbumService {

    Logger logger = LoggerFactory.getLogger(AlbumService.class);

    private static final CountryCode BRASIL = CountryCode.BR;
    private static final Integer QUANTIDADE_ALBUNS_MAXIMO = 50;
    private static final Integer QUANTIDADE_ALBUNS_POR_PAGINA = 10;

    private static final SpotifyApi spotityApi = SpotifyApiCredentials.getSpotifyApi();

    @Autowired
    Messages messages;

    public List<Disco> obterAlbunsPorGenero(String descricaGenero, String pagina) throws ApiException {
        Integer quantidadeAlbuns = QUANTIDADE_ALBUNS_MAXIMO;
        Integer inicioContagem = 0;

        try {

            GeneroEnum genero = this.obterGeneroPorDescricao(descricaGenero);

            if (!pagina.isEmpty()) {
                quantidadeAlbuns = QUANTIDADE_ALBUNS_POR_PAGINA;
                inicioContagem = obterInicioDaPaginacao(pagina);
            }

            final Paging<AlbumSimplified> albumSimplifiedPaging =
                    getAlbumSimplifiedPaging(quantidadeAlbuns, inicioContagem, genero);

            Stream<AlbumSimplified> albuns = getAlbunsOrdenados(albumSimplifiedPaging);


            return albuns.map(a ->
                    new Disco(a.getId(), a.getName(), a.getType().getType(), ValorUtil.gerarValorRandomico(a.getArtists().length)))
                    .collect(Collectors.toList());

        } catch (IOException | SpotifyWebApiException e) {
            logger.error("Erro ao obter álbums por Gênero -> {}", e.getMessage());
            throw new ApiException(messages.get("erro.album.genero"));
        }
    }

    public Disco obterAlbumPorId(String id) throws ApiException {

        try {

            logger.info("Obtendo Objeto Album da SpotifyApi");
            Album album = this.getAlbumSpotify(id);

            logger.info("Retornando model Disco transformado");
            return externalToDisco.apply(album);

        } catch (IOException | SpotifyWebApiException e) {
            logger.error("Erro ao obter Álbum por id {}. Erro -> {} ", id, e.getMessage());
            throw new ApiException(messages.get("erro.album.id.invalido"));
        }

    }

    private Album getAlbumSpotify(String id) throws IOException, SpotifyWebApiException {
        final GetAlbumRequest albumRequest = spotityApi
                .getAlbum(id)
                .market(BRASIL).build();

        return albumRequest.execute();
    }

    private Integer obterInicioDaPaginacao(String pagina) throws ApiException {
        Integer numPagina = 0;
        Integer inicioContagem;
        try {
            numPagina = Integer.valueOf(pagina);

            if (numPagina < 1 || numPagina > 5) {
                throw new ApiException(messages.get("erro.numero.pagina.invalido"));
            }

            inicioContagem = (numPagina - 1) * QUANTIDADE_ALBUNS_POR_PAGINA;


        } catch (NumberFormatException ne) {
            logger.error("Erro ao obter offset (início da paginação) -> {} ", ne.getMessage());
            throw new ApiException(messages.get("erro.paginacao.invalida"));
        }
        return inicioContagem;
    }

    private GeneroEnum obterGeneroPorDescricao(String descricaGenero) throws ApiException {
        try {
            return GeneroEnum.valueOf(descricaGenero.toUpperCase());
        } catch (IllegalArgumentException ile) {
            logger.error("Erro ao obter enum do Genero pela descrição informada -> {} ", ile.getMessage());
            throw new ApiException(messages.get("erro.album.genero.invalido"));
        }
    }

    private Stream<AlbumSimplified> getAlbunsOrdenados(Paging<AlbumSimplified> albumSimplifiedPaging) {
        return Arrays.stream(albumSimplifiedPaging.getItems())
                .filter(a -> a.getType().equals(ModelObjectType.ALBUM))
                .sorted(Comparator.comparing(AlbumSimplified::getName));
    }

    private Paging<AlbumSimplified> getAlbumSimplifiedPaging(Integer quantidadeAlbuns, Integer inicioContagem, GeneroEnum genero) throws IOException, SpotifyWebApiException {
        final SearchAlbumsRequest searchAlbumsRequest = spotityApi.searchAlbums(genero.getDescricao())
                .market(BRASIL)
                .offset(inicioContagem)
                .limit(quantidadeAlbuns)
                .build();

        return searchAlbumsRequest.execute();
    }

    private Function<Album, Disco> externalToDisco =
            album -> new Disco(album.getId(),
                               album.getName(),
                               album.getType().getType(),
                               ValorUtil.gerarValorRandomico(album.getPopularity()));
}
