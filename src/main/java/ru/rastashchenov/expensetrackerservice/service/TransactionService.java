package ru.rastashchenov.expensetrackerservice.service;

import ru.rastashchenov.expensetrackerservice.dto.TransactionRequestDto;
import ru.rastashchenov.expensetrackerservice.dto.TransactionResponseDto;

public interface TransactionService {
    TransactionResponseDto save(TransactionRequestDto transactionRequestDto);
}
