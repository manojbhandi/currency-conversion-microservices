package com.micorservices.project.currencyexchangeservice.repositories;

import com.micorservices.project.currencyexchangeservice.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
