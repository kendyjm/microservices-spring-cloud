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

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy; //our Feign client for CurrencyExchange services

    /*
     * Classic WS call , using RestTemplate...there is too much code here, see the version using the WS client : FEIGN
     */
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionBean> convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("Received request : from {} to {} quantity {}", from, to, quantity);

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

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversionBean> convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("Received request (feign) : from {} to {} quantity {}", from, to, quantity);
        CurrencyConversionBean currencyConversionBean = currencyExchangeProxy.retrieveExchangeValue(from, to);
        logger.info("Response from exchange service : {}", currencyConversionBean);

        CurrencyConversionBean currencyConversionBeanReturned = new CurrencyConversionBean(currencyConversionBean.getId(), currencyConversionBean.getFrom(), currencyConversionBean.getTo(), currencyConversionBean.getConversionMultiple(), quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
        logger.info("Returned response : {}", currencyConversionBeanReturned);
        return ResponseEntity.ok(currencyConversionBeanReturned);
    }
}
