package com.beblue.cashback.repository;

import com.beblue.cashback.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);
}
