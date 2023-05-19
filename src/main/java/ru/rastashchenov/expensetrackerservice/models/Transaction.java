package ru.rastashchenov.expensetrackerservice.models;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Digits(message="Account should contain 10 digits.", fraction = 0, integer = 10)
    private String accountFrom;
    @Digits(message="Account should contain 10 digits.", fraction = 0, integer = 10)
    private String accountTo;
    @Min(value = 0, message = "Sum must be greater than or equal to 0")
    private BigDecimal sum;
    @NotBlank(message = "Currency shortname can't be empty")
    private String currencyShortname;
    @NotBlank(message = "Expense category can't be empty")
    private String expenseCategory;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datetime;
    private Long transactionClient;
    private Long transactionLimit;
    private Long limitExceeded;

}
