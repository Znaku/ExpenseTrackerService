package ru.rastashchenov.expensetrackerservice.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.rastashchenov.expensetrackerservice.feign.servise.ExchangeRateService;

@Component
public class ExchangeRateScheduler {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateScheduler(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Scheduled(cron = "0 20 11 * * *")
    public void runExchangeRateService() {
        exchangeRateService.getAndSaveExchangeRates();
    }
}
