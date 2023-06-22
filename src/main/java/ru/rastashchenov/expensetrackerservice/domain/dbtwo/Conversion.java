package ru.rastashchenov.expensetrackerservice.domain.dbtwo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Entity
@Data
@Accessors(chain = true)
@Table(value = "conversion")
@NoArgsConstructor
public class Conversion {

    @PrimaryKey
    @EmbeddedId
    @Getter(value= AccessLevel.PRIVATE)
    @Setter(value=AccessLevel.PRIVATE)
    private ConversionKey conversionKey = new ConversionKey();

    @Column(value = "rate")
    private BigDecimal rate;

    @Column(value = "rate_on_previous_close")
    private BigDecimal rateOnPreviousClose;

    public LocalDate getMadeAt() {
        return conversionKey.getMadeAt();
    }

    public Conversion setMadeAt(LocalDate localDate) {
        conversionKey.setMadeAt(localDate);
        return this;
    }

    public String getSymbol() {
        return conversionKey.getSymbol();
    }

    public Conversion setSymbol(String symbol) {
        conversionKey.setSymbol(symbol);
        return this;
    }
}
