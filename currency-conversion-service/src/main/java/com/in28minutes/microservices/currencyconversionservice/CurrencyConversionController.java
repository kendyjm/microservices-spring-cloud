package com.in28minutes.microservices.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
    public static final String CURRENCY_EXCHANGE_FROM_TO = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

    @Autowired
    private Environment environment;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionBean> convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("Received request : from {} to {} quantity {}", from, to, quantity);


        // hardcoded
        // int serverPort = Integer.parseInt(environment.getRequiredProperty("local.server.port"));
        // CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(1L, from, to, BigDecimal.valueOf(65), quantity, BigDecimal.valueOf(65).multiply(quantity), serverPort);


        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(CURRENCY_EXCHANGE_FROM_TO, CurrencyConversionBean.class, uriVariables);
        logger.info("responseEntity : {}", responseEntity);
        CurrencyConversionBean currencyConversionBean = responseEntity.getBody();
        logger.info("Response conversion : {}", currencyConversionBean);

        CurrencyConversionBean currencyConversionBeanReturned = new CurrencyConversionBean(currencyConversionBean.getId(), currencyConversionBean.getFrom(), currencyConversionBean.getTo(), currencyConversionBean.getConversionMultiple(), quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
        return ResponseEntity.ok(currencyConversionBeanReturned);
    }
}
