package ru.rastashchenov.expensetrackerservice.repository.dbone;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Client;

import java.math.BigInteger;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM client WHERE bank_account_number=:bank_account_number LIMIT 1")
    Client getClientByBankAccountNumber(BigInteger bankAccountNumber);
}
