package com.ostad.financetracker.Service;

import com.ostad.financetracker.Model.Transaction;
import com.ostad.financetracker.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public List<Transaction> getTransactionsByType(String type) {
        return transactionRepository.findByTransactionTypeIgnoreCase(type.toLowerCase());
    }
    public Optional<Transaction> getTransactionById(Long transactionNo) {
        return transactionRepository.findById(transactionNo);
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public boolean deleteTransactionById(Long transactionNo) {
        if (transactionRepository.existsById(transactionNo)) {
            transactionRepository.deleteById(transactionNo);
            return true;
        }
        return false;
    }

}
