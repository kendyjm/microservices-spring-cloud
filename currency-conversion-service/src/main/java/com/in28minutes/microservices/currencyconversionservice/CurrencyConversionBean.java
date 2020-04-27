package com.in28minutes.microservices.currencyconversionservice;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionBean {
    Long id;
    String from;
    String to;
    BigDecimal conversionMultiple;
    BigDecimal quantity;
    BigDecimal totalCalculatedAmount;
    int port;
}
