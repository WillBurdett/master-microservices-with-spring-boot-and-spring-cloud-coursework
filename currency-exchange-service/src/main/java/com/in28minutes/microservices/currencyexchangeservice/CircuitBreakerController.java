package com.in28minutes.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

 private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
 @GetMapping("sample-api")
 //@Retry(name = "default")
 //@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")

// At what given percentage of successful API calls (90%) will I begin returning a default response (set to 'OPEN')
 //@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

 // in 10s I only want to allow 10_000 calls, specific to this API call
 //@RateLimiter(name = "default")

 // how many concurrent calls do you want to allow
 @Bulkhead(name = "sample-api")
  public String sampleApi(){
  logger.info("Sample api call received");
//  ResponseEntity<String> forEntity =
//      new RestTemplate()
//          .getForEntity("http://localhost:8080/some-dummy-url", String.class);
//  return forEntity.getBody();
   return "sample-api";
 }

 // must handle throwable (by extending exception)
 // you can handle different exceptions with different responses
 public String hardcodedResponse(Exception ex){
   return "fallback-response";
 }
}
