package com.beblue.cashback.model;

import com.beblue.cashback.model.enums.GeneroEnum;
import com.wrapper.spotify.model_objects.specification.ExternalUrl;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity(name = "disco")
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "id_spotify")
    private String identificadorSpotiy;

    @Column(name = "tx_nome")
    private String nome;

    @Column(name = "cd_genero")
    @Enumerated(EnumType.ORDINAL)
    private GeneroEnum genero;

    @NotNull
    @Column(name = "vl_preco")
    private BigDecimal preco;


}
