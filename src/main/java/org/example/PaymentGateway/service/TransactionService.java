package org.example.PaymentGateway.service;

import org.example.PaymentGateway.controller.InstrumentController;
import org.example.PaymentGateway.dto.InstrumentDTO;
import org.example.PaymentGateway.dto.TransactionDTO;
import org.example.PaymentGateway.entity.Transaction;
import org.example.PaymentGateway.enums.TransactionStatus;

import java.util.*;

public class TransactionService {
    public static Map<Integer, List<Transaction>> userVsTransactionsList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService(){
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userID){
        return userVsTransactionsList.get(userID);
    }

    public TransactionDTO makePayment(TransactionDTO txnDTO){
        InstrumentDTO senderInstrumentDTO = instrumentController.getInstrumentByID(txnDTO.getSenderUserID(), txnDTO.getDebitInstrumentID());
        InstrumentDTO receiverInstrumentDTO = instrumentController.getInstrumentByID(txnDTO.getReceiverUserID(), txnDTO.getCreditInstrumentID());

        processor.processPayment(senderInstrumentDTO, receiverInstrumentDTO);

        Transaction txn = new Transaction();
        txn.setAmount(txnDTO.getAmount());
        txn.setTxnID(new Random().nextInt(100-10) + 10);
        txn.setSenderUserID(txnDTO.getSenderUserID());
        txn.setReceiverUserID(txnDTO.getReceiverUserID());
        txn.setDebitInstrumentID(txnDTO.getDebitInstrumentID());
        txn.setCreditInstrumentID(txnDTO.getCreditInstrumentID());
        txn.setStatus(TransactionStatus.SUCCESS);
        List<Transaction> senderTxnsList = userVsTransactionsList.get(txn.getSenderUserID());
        if(senderTxnsList == null){
            senderTxnsList = new ArrayList<>();
            userVsTransactionsList.put(txn.getSenderUserID(), senderTxnsList);
        }
        senderTxnsList.add(txn);
        List<Transaction> receiverTxnsList = userVsTransactionsList.get(txn.getReceiverUserID());
        if(receiverTxnsList == null){
            receiverTxnsList = new ArrayList<>();
            userVsTransactionsList.put(txn.getReceiverUserID(), receiverTxnsList);
        }
        receiverTxnsList.add(txn);

        txnDTO.setTxnID(txn.getTxnID());
        txnDTO.setStatus(txn.getStatus());
        return txnDTO;
    }
}
