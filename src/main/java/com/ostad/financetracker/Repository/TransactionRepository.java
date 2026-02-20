package com.ostad.financetracker.Repository;

import com.ostad.financetracker.Model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    // The required in-memory List store
    private final List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> findAll() {
        return transactions;
    }

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }
}