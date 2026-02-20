package com.ostad.financetracker.Controller;

import com.ostad.financetracker.Model.Transaction;
import com.ostad.financetracker.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }


    @GetMapping
    public List<Transaction> getTransactions(@RequestParam(required = false) String type) {
        if (type != null) {
            return service.getTransactionsByType(type);
        }
        return service.getAllTransactions();
    }


    @GetMapping("/{id}")
    public Transaction getById(@PathVariable String id) {
        return service.getTransactionById(id).orElse(null);
    }


    @PostMapping
    public Transaction add(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return service.deleteTransaction(id) ? "Deleted successfully" : "Transaction not found";
    }
}