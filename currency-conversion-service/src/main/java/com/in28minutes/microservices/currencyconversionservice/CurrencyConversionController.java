package com.in28minutes.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    private Environment environment;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionBean> convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("Received request : from {} to {} quantity {}", from, to, quantity);
        int serverPort = Integer.parseInt(environment.getRequiredProperty("local.server.port"));
        CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(1L, from, to, BigDecimal.valueOf(65), quantity, BigDecimal.valueOf(65).multiply(quantity), serverPort);
        logger.info("Response conversion : {}", currencyConversionBean);
        return ResponseEntity.ok(currencyConversionBean);
    }
}
