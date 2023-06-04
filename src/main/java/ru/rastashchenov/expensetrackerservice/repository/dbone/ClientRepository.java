package ru.rastashchenov.expensetrackerservice.repository.dbone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
