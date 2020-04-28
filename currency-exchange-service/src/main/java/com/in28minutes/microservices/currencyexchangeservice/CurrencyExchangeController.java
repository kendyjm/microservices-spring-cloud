package com.in28minutes.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeValue> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        logger.info("Received request : from {} to {}", from, to);
        //ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndToAllIgnoreCase(from, to);
        logger.info("exchangeValue {}", exchangeValue);

        String serverPort = environment.getRequiredProperty("local.server.port");
        int serverPortInt = Integer.valueOf(serverPort);
        logger.info("serverPortInt {}", serverPortInt);
        exchangeValue.setPort(serverPortInt);
        logger.info("Returned response : {}", exchangeValue);
        return ResponseEntity.ok(exchangeValue);
    }
}
