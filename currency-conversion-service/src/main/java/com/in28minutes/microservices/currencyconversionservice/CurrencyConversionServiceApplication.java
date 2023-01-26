package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}


	// Currency Conversion Service:
	// http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	// http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
}
