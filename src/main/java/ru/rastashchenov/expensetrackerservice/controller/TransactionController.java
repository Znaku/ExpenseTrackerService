package ru.rastashchenov.expensetrackerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rastashchenov.expensetrackerservice.dto.TransactionRequestDto;
import ru.rastashchenov.expensetrackerservice.dto.TransactionResponseDto;
import ru.rastashchenov.expensetrackerservice.service.TransactionService;

@RestController
@RequestMapping("/api/transactions/new")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDto> createTransaction(@RequestBody TransactionRequestDto transactionRequestDto) {
        return ResponseEntity.ok(transactionService.save(transactionRequestDto));
    }

    @GetMapping
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("ok");
    }
}
