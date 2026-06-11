package org.example.PaymentGateway.dto;

import org.example.PaymentGateway.enums.TransactionStatus;

public class TransactionDTO {
    int txnID;
    int amount;
    int senderUserID;
    int receiverUserID;
    int debitInstrumentID;
    int creditInstrumentID;
    TransactionStatus status;

    public int getTxnID() {
        return txnID;
    }

    public void setTxnID(int txnID) {
        this.txnID = txnID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSenderUserID() {
        return senderUserID;
    }

    public void setSenderUserID(int senderUserID) {
        this.senderUserID = senderUserID;
    }

    public int getReceiverUserID() {
        return receiverUserID;
    }

    public void setReceiverUserID(int receiverUserID) {
        this.receiverUserID = receiverUserID;
    }

    public int getDebitInstrumentID() {
        return debitInstrumentID;
    }

    public void setDebitInstrumentID(int debitInstrumentID) {
        this.debitInstrumentID = debitInstrumentID;
    }

    public int getCreditInstrumentID() {
        return creditInstrumentID;
    }

    public void setCreditInstrumentID(int creditInstrumentID) {
        this.creditInstrumentID = creditInstrumentID;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}