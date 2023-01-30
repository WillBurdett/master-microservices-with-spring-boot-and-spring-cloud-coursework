package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}

// Currency Exchange Service:
// http://localhost:8000/currency-exchange/from/USD/to/INR

// Using API gateway:
// http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR
//
//{
//		"id":10001,
//		"from":"USD",
//		"to":"INR",
//		"conversionMultiple":65.00,
//		"environment":"8000 instance-id"
//		}