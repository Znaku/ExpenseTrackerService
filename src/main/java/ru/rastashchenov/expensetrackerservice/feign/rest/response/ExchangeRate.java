package ru.rastashchenov.expensetrackerservice.feign.rest.response;

import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Accessors(chain = true)
public class ExchangeRate {

    private String symbol;
    private BigDecimal rate;
    private Instant timestamp;

}
