package ru.rastashchenov.expensetrackerservice.models;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
public class Conversion {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private BigDecimal rate;
    private BigDecimal rateOnPreviousClose;
    private LocalDateTime madeAt;
    private String symbol;

}
