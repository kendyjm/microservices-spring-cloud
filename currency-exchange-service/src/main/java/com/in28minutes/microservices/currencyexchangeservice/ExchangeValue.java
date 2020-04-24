package com.in28minutes.microservices.currencyexchangeservice;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ExchangeValue {

    private final Long id;
    private final String from;
    private final String to;
    private final BigDecimal conversionMultiple;

}
