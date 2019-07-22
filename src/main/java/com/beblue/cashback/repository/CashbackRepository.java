package com.beblue.cashback.repository;

import com.beblue.cashback.model.Cashback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashbackRepository extends CrudRepository<Cashback, Long> {
}
