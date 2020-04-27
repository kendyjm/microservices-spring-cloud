package com.in28minutes.microservices.currencyexchangeservice;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @Column(name = "currency_from")
    private final String from;

    @Column(name = "currency_to")
    private final String to;
    private final BigDecimal conversionMultiple;
    private int port; // server port

}
