package com.beblue.cashback.model;

import com.wrapper.spotify.model_objects.specification.ExternalUrl;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Disco {

    String id;
    String nome;
    String tipoAlbum;
    ExternalUrl linksSpotiy;
    BigDecimal preco;

    public Disco(String idAlbum, String nome) {
        this.id = idAlbum;
        this.nome = nome;
    }
}
