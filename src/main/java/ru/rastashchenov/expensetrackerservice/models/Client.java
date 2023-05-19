package ru.rastashchenov.expensetrackerservice.models;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Bank account number can't be empty")
    private String bankAccountNumber;
    @OneToMany(mappedBy = "id")
    private List<Transaction> clientTransactions;
    @OneToMany(mappedBy = "id")
    private List<Limit> clientLimits;

}
