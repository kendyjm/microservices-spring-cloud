package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * We use use feign, which is a web service CLIENT, to talk to an external microservice, "currency-exchange-service" here.
 * No more need of RestTemplate !
 * Note @EnableFeignClients in main class to enable feign and the search for feign clients like this one.
 * <p>
 * Note also that Placeholders are supported in the name and url attributes.
 * example @FeignClient(name = "${feign.name}", url = "${feign.url}")
 *
 * @see https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html
 */
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000") url is not needed thanks to ribbon
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}