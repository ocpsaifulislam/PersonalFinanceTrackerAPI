package com.ostad.financetracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private static final AtomicLong COUNTER = new AtomicLong(1);
    private String id;
    private String type; // "INCOME" or "EXPENSE"
    private double amount;
    private String description;
    private String date;

}