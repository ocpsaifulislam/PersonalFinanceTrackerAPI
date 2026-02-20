package com.ostad.financetracker.Service;

import com.ostad.financetracker.Model.Transaction;
import com.ostad.financetracker.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


@Service
public class TransactionService {
    private final TransactionRepository repository;

    private static final AtomicLong COUNTER = new AtomicLong(1);

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }


    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(repository.findAll());
    }


    public Optional<Transaction> getTransactionById(String id) {
        return repository.findAll().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }


    public boolean deleteTransaction(String id) {
        return repository.findAll().removeIf(t -> t.getId().equals(id));
    }


    public Transaction addTransaction(Transaction transaction) {
        if (transaction.getId() == null) {
            transaction.setId(String.valueOf(COUNTER.getAndIncrement()));
        }
        repository.save(transaction);
        return transaction;
    }


    public List<Transaction> getTransactionsByType(String type) {
        return repository.findAll().stream()
                .filter(t -> t.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}