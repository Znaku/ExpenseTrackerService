package ru.rastashchenov.expensetrackerservice.repository.dbtwo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rastashchenov.expensetrackerservice.domain.dbtwo.Conversion;

import java.util.UUID;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, UUID> {
}
