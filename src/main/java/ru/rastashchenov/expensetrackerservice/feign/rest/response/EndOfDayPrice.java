package ru.rastashchenov.expensetrackerservice.feign.rest.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class EndOfDayPrice {
    private String symbol;
    private String exchange;
    private String mic_code;
    private String currency;
    private LocalDate datetime;
    private BigDecimal close;
}
