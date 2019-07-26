package com.beblue.cashback.model;

import com.beblue.cashback.model.enums.DiaEnum;
import com.beblue.cashback.model.enums.GeneroEnum;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity(name = "cashback")
public class Cashback {

    @Id
    private Long id;

    @Column(name = "cd_dia")
    @Enumerated(EnumType.ORDINAL)
    private DiaEnum codigoDia;

    @Column(name = "cd_genero")
    @Enumerated(EnumType.ORDINAL)
    private GeneroEnum codigoGenero;

    @Column(name = "vl_percentual", nullable = false, precision = 5, scale  = 2)
    private BigDecimal percentual;

}
