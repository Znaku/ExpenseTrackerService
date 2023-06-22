package ru.rastashchenov.expensetrackerservice.feign.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rastashchenov.expensetrackerservice.feign.client.ExchangeRateApiClient;

@RestController
@RequestMapping("/exchange_rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateApiClient exchangeRateApiClient;

    @GetMapping
    public ResponseEntity readExchangeRateData() {

/*        return ResponseEntity.ok();*/

        return null;

    }
}
