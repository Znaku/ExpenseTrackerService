package ru.rastashchenov.expensetrackerservice.feign.servise;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.rastashchenov.expensetrackerservice.domain.dbtwo.Conversion;
import ru.rastashchenov.expensetrackerservice.feign.client.ExchangeRateApiClient;
import ru.rastashchenov.expensetrackerservice.feign.rest.response.ExchangeRate;
import ru.rastashchenov.expensetrackerservice.repository.dbtwo.ConversionRepository;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
@Slf4j
public class ExchangeRateServiceImpl implements ExchangeRateService{

    @Value("${application.main-currency}")
    private String mainCurrency;
    @Value("${application.additional-currencies}")
    private String[] additionalCurrencies;
    @Value("${application.exchange-rate-api-service.apikey}")
    private String apikey;
    private final String systemZoneID = ZoneId.systemDefault().toString();
    private final ConversionRepository conversionRepository;
    private final ExchangeRateApiClient exchangeRateApiClient;

    @Autowired
    public ExchangeRateServiceImpl(ConversionRepository conversionRepository, ExchangeRateApiClient exchangeRateApiClient) {
        this.conversionRepository = conversionRepository;
        this.exchangeRateApiClient = exchangeRateApiClient;
    }

    public void getAndSaveExchangeRates() {

        for (String s: additionalCurrencies) {
            try {
                getAndSaveExchangeRate(mainCurrency + "/" + s);
            } catch (FeignException e) {
                log.error("Failed to call the HTTP service by the client. ", e);
            }
        }
    }

    private void getAndSaveExchangeRate(String symbol) {

        Conversion conversion = conversionRepository.getLast(symbol);

        LocalDate nowDate = LocalDate.now();

        if (conversion == null || !conversion.getMadeAt().equals(nowDate)) {
            ExchangeRate exchangeRate = exchangeRateApiClient.getExchangerate(symbol, apikey, systemZoneID);

            String yesterdayDate = nowDate.minusDays(1).toString();
            ExchangeRate previousExchangeRate = exchangeRateApiClient.getExchangerate(symbol, apikey, systemZoneID, yesterdayDate);

            conversionRepository.save(
                    new Conversion()
                    .setSymbol(symbol)
                    .setMadeAt(nowDate)
                    .setRate(exchangeRate.getRate())
                    .setRateOnPreviousClose(previousExchangeRate.getRate())
            );
        }
    }

}
