package com.beblue.cashback.model;

import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.ExternalUrl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disco disco = (Disco) o;
        return id.equals(disco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
