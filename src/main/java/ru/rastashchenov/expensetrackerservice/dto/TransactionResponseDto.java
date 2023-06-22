package ru.rastashchenov.expensetrackerservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TransactionResponseDto {
    private BigInteger account_from;
    private BigDecimal account_to;
    private String currency_shortname;
    private String sum;
    private String expense_category;
    private LocalDateTime datetime;
    private BigDecimal limit_sum;
    private LocalDateTime limit_datetime;
    private String limit_currency_shortname;
}
