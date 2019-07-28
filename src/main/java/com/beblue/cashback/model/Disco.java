package com.beblue.cashback.model;

import com.wrapper.spotify.model_objects.specification.ExternalUrl;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Disco {

    @NotNull
    private String id;
    private String nome;
    private String tipoAlbum;
    @NotNull
    private BigDecimal preco;

}
