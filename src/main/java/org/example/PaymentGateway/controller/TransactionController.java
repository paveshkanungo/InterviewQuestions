package org.example.PaymentGateway.controller;

import org.example.PaymentGateway.dto.TransactionDTO;
import org.example.PaymentGateway.entity.Transaction;
import org.example.PaymentGateway.service.TransactionService;

import java.util.List;

public class TransactionController {
    TransactionService txnSerivce;

    public TransactionController(){
        txnSerivce = new TransactionService();
    }

    public TransactionDTO makePayment(TransactionDTO txnDTO){
        return txnSerivce.makePayment(txnDTO);
    }

    public List<Transaction> getTransactionHistory(int userID){
        return txnSerivce.getTransactionHistory(userID);
    }
}
