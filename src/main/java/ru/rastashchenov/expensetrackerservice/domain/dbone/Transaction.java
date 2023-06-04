package ru.rastashchenov.expensetrackerservice.domain.dbone;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSeq")
    @SequenceGenerator(name = "transactionSeq", sequenceName = "transaction_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_from")
    private String accountFrom;

    @Column(name = "account_to")
    private String accountTo;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "currency_shortname")
    private String currencyShortname;

    @Column(name = "expense_category")
    private String expenseCategory;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "transaction_client")
    private Long transactionClient;

    @Column(name = "transaction_limit")
    private Long transactionLimit;

    @Column(name = "limit_exceeded")
    private boolean limitExceeded;

}
