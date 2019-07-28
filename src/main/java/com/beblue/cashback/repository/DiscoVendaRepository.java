package com.beblue.cashback.repository;

import com.beblue.cashback.model.DiscoVenda;
import com.beblue.cashback.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscoVendaRepository  extends JpaRepository<DiscoVenda, Long> {

    List<DiscoVenda> findAllByVenda(Venda venda);
}
