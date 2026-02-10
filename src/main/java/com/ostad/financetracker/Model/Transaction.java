package com.ostad.financetracker.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "IN_TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_NO")
    private Long transactionNo;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TRANSACTION_DATE")
    private LocalDate transactionDate;

}
