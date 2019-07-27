package com.beblue.cashback.repository;

import com.beblue.cashback.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashbackRepository extends JpaRepository<Venda, Long> {
}
