package com.beblue.cashback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "cashback_dia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cashback {

    @Id
    private Long id;

    @Column(name = "dia")
    private Integer codigoDia;

    @Column(name = "genero_id")
    private Integer codigoGenero;

    @Column(name = "cashback")
    private Integer valorPercentual;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashback cashback = (Cashback) o;
        return id.equals(cashback.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
