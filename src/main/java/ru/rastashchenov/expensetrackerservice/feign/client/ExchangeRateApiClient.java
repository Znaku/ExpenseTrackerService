package ru.rastashchenov.expensetrackerservice.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rastashchenov.expensetrackerservice.feign.rest.response.EndOfDayPrice;
import ru.rastashchenov.expensetrackerservice.feign.rest.response.ExchangeRate;

@FeignClient(value = "twelvedata-api", url = "${application.exchange-rate-api-service.url}")
public interface ExchangeRateApiClient {

    @GetMapping("/exchange_rate")
    ExchangeRate getExchangerate(@RequestParam("symbol") String symbol,
                                 @RequestParam("apikey") String apikey,
                                 @RequestParam("timezone") String timezone);

    @GetMapping("/exchange_rate")
    ExchangeRate getExchangerate(@RequestParam("symbol") String symbol,
                                 @RequestParam("apikey") String apikey,
                                 @RequestParam("timezone") String timezone,
                                 @RequestParam("date")  String date);

    @GetMapping("/eod")
    EndOfDayPrice getEndOfDayPrice(@RequestParam("symbol") String symbol,
                                   @RequestParam("apikey") String apikey);
}
