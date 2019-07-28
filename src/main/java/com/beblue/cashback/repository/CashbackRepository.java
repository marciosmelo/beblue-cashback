package com.beblue.cashback.repository;

import com.beblue.cashback.model.Cashback;
import com.beblue.cashback.model.enums.DiaEnum;
import com.beblue.cashback.model.enums.GeneroEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;

@Repository
public interface CashbackRepository extends JpaRepository<Cashback, Long> {

    @Query("SELECT cash FROM Cashback cash WHERE cash.genero = ?1 AND cash.dia = ?2")
    Cashback obterPorGeneroDia(GeneroEnum codigoGenero, DiaEnum dia);
}
