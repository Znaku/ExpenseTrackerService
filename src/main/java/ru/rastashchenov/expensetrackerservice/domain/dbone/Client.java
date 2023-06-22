package ru.rastashchenov.expensetrackerservice.domain.dbone;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientSeq")
    @SequenceGenerator(name = "clientSeq", sequenceName = "client_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    @OneToMany(mappedBy = "id")
    private List<Transaction> clientTransactions;
    @OneToMany(mappedBy = "id")
    private List<Limit> clientLimits;

}
