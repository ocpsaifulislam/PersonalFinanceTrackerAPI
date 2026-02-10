package com.ostad.financetracker.Controller;

import com.ostad.financetracker.Model.Transaction;
import com.ostad.financetracker.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions(@RequestParam(required = false) String type) {
        if (type != null) {
            return transactionService.getTransactionsByType(type);
        }
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable Long id) {
        return transactionService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable Long id) {
        boolean deleted = transactionService.deleteTransactionById(id);

        if (deleted) {
            return ResponseEntity.ok("Transaction deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
