package com.beblue.cashback.repository;

import com.beblue.cashback.model.Cashback;
import com.beblue.cashback.model.enums.DiaEnum;
import com.beblue.cashback.model.enums.GeneroEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashbackRepository extends JpaRepository<Cashback, Long> {

    Cashback findByGeneroAndDia(GeneroEnum genero, DiaEnum dia);
}
