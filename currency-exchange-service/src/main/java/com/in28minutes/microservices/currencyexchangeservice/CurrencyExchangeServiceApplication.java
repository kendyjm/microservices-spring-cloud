package com.in28minutes.microservices.currencyexchangeservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler() {
        // In production, you don't want to trace every request.
        // Sampler beans helps you to customize how much percentage of requests you want to trace.
        return Sampler.ALWAYS_SAMPLE;
    }
}
