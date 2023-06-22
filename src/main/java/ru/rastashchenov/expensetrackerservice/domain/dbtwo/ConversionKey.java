package ru.rastashchenov.expensetrackerservice.domain.dbtwo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@PrimaryKeyClass
@EqualsAndHashCode
@Accessors(chain = true)
public class ConversionKey implements Serializable {

    @PrimaryKeyColumn(name = "symbol", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String symbol;
    @PrimaryKeyColumn(name = "made_at", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private LocalDate madeAt;

}
