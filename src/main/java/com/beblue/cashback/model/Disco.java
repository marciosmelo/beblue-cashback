package com.beblue.cashback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Disco {

    String id;
    String name;
    String [] generos;

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
