package ru.rastashchenov.expensetrackerservice.repository.dbtwo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rastashchenov.expensetrackerservice.domain.Conversion;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {
}
