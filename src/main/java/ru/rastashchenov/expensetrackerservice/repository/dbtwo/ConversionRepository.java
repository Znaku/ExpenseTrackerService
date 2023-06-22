package ru.rastashchenov.expensetrackerservice.repository.dbtwo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rastashchenov.expensetrackerservice.domain.dbtwo.Conversion;
import ru.rastashchenov.expensetrackerservice.domain.dbtwo.ConversionKey;
import java.time.LocalDate;

@Repository
public interface ConversionRepository extends CassandraRepository<Conversion, ConversionKey> {

    @Query(value = "SELECT * FROM conversion WHERE symbol=:symbol ORDER BY made_at DESC LIMIT 1")
    public Conversion getLast(String symbol);

    @Query(value = "SELECT * FROM conversion WHERE symbol=:symbol and made_at<=:date ORDER BY made_at DESC LIMIT 1")
    public Conversion getLast(String symbol, LocalDate date);

}
