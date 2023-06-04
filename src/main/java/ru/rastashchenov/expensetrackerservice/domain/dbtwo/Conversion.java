package ru.rastashchenov.expensetrackerservice.domain.dbtwo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Entity
@Accessors(chain = true)
@Table(value = "conversion")
public class Conversion {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")

    @PrimaryKey
    @Column(name = "id")
    private UUID id;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "rate_on_previous_close")
    private BigDecimal rateOnPreviousClose;

    @Column(name = "made_at")
    private LocalDateTime madeAt;

    @Column(name = "symbol")
    private String symbol;

}
