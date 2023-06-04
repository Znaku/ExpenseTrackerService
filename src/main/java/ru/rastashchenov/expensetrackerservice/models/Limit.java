package ru.rastashchenov.expensetrackerservice.models;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
public class Limit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Min(value = 0, message = "Limit sum must be greater than or equal 0")
    private BigDecimal limitSum;
    @NotNull(message = "Remaining month limit can't be empty")
    private BigDecimal remainingMonthLimit;
    private LocalDateTime limitDateTime;
    @NotBlank(message = "Limit currency shortname can't be empty")
    private String limitCurrencyShortname;
    @NotBlank(message = "Limit expense category can't be empty")
    private String limitExpenseCategory;
    private Long limitClient;
    @OneToMany(mappedBy = "id")
    private List<Transaction> limitTransactions;

}
