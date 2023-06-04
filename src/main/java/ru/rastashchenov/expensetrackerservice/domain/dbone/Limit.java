package ru.rastashchenov.expensetrackerservice.domain.dbone;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "limitSeq")
    @SequenceGenerator(name = "limitSeq", sequenceName = "limit_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "limit_sum")
    private BigDecimal limitSum;

    @Column(name = "remaining_month_limit")
    private BigDecimal remainingMonthLimit;

    @Column(name = "limit_date_time")
    private LocalDateTime limitDateTime;

    @Column(name = "limit_currency_shortname")
    private String limitCurrencyShortname;

    @Column(name = "limit_expense_category")
    private String limitExpenseCategory;

    @Column(name = "limit_client")
    private Long limitClient;

    @OneToMany(mappedBy = "id")
    private List<Transaction> limitTransactions;

}
