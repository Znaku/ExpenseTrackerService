package ru.rastashchenov.expensetrackerservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rastashchenov.expensetrackerservice.domain.dbone.Client;
import ru.rastashchenov.expensetrackerservice.dto.TransactionRequestDto;
import ru.rastashchenov.expensetrackerservice.dto.TransactionResponseDto;
import ru.rastashchenov.expensetrackerservice.repository.dbone.ClientRepository;
import ru.rastashchenov.expensetrackerservice.repository.dbone.TransactionRepository;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final ClientRepository clientRepository;

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(ClientRepository clientRepository, TransactionRepository transactionRepository) {
        this.clientRepository = clientRepository;
        this.transactionRepository = transactionRepository;
    }



    @Override
    public TransactionResponseDto save(TransactionRequestDto transactionRequestDto) {

        //Work in progress
        ModelMapper modelMapper = new ModelMapper();

        Client client = Optional.ofNullable(clientRepository.getClientByBankAccountNumber(transactionRequestDto.getAccount_from())).
                orElse(clientRepository.save(modelMapper.map(transactionRequestDto, Client.class)));


        return new TransactionResponseDto();
    }
}
