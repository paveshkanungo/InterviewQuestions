package org.example.PaymentGateway;

import org.example.PaymentGateway.controller.InstrumentController;
import org.example.PaymentGateway.controller.TransactionController;
import org.example.PaymentGateway.controller.UserController;
import org.example.PaymentGateway.dto.InstrumentDTO;
import org.example.PaymentGateway.dto.TransactionDTO;
import org.example.PaymentGateway.dto.UserDTO;
import org.example.PaymentGateway.entity.Transaction;
import org.example.PaymentGateway.enums.InstrumentType;

import java.util.List;

public class PaymentGateway {
    public static void main(String[] args) {
        InstrumentController instrumentController = new InstrumentController();
        UserController userController = new UserController();
        TransactionController transactionController = new TransactionController();

        // 1. add USER1
        UserDTO user1 = new UserDTO();
        user1.setName("PK");
        user1.setMail("paveshkanungo@gmail.com");
        UserDTO user1Details = userController.addUser(user1);

        // 1. add USER2
        UserDTO user2 = new UserDTO();
        user2.setName("SK");
        user2.setMail("santoshkanungo@gmail.com");
        UserDTO user2Details = userController.addUser(user2);

        // add bank to User1
        InstrumentDTO bankInstrumentDTO = new InstrumentDTO();
        bankInstrumentDTO.setBankAccountNumber("1234567");
        bankInstrumentDTO.setInstrumentType(InstrumentType.BANK);
        bankInstrumentDTO.setUserID(user1Details.getUserID());
        bankInstrumentDTO.setIfsc("ER3223E");
        InstrumentDTO user1BankInstrument = instrumentController.addInstrument(bankInstrumentDTO);
        System.out.println("Bank Instrument created for User1: " + user1BankInstrument.getInstrumentID());

        // add bank to User2
        InstrumentDTO cardInstrumentDTO = new InstrumentDTO();
        cardInstrumentDTO.setCardNumber("123456");
        cardInstrumentDTO.setInstrumentType(InstrumentType.CARD);
        cardInstrumentDTO.setCvv("0000");
        cardInstrumentDTO.setUserID(user2Details.getUserID());
        InstrumentDTO user2CardInstrument = instrumentController.addInstrument(cardInstrumentDTO);
        System.out.println("Card Instrument created for User2: " + user2CardInstrument.getInstrumentID());

        // make payment
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(10);
        transactionDTO.setSenderUserID(user1Details.getUserID());
        transactionDTO.setReceiverUserID(user2Details.getUserID());
        transactionDTO.setDebitInstrumentID(user1BankInstrument.getInstrumentID());
        transactionDTO.setCreditInstrumentID(user2CardInstrument.getInstrumentID());
        transactionController.makePayment(transactionDTO);

        // get all instruments of USER1
        List<InstrumentDTO> user1Instruments = instrumentController.getAllInstruments(user1Details.getUserID());
        for(InstrumentDTO instrumentDTO: user1Instruments){
            System.out.println("User1 InstID: " + instrumentDTO.getInstrumentID() + ": UserID: " +
                    instrumentDTO.getUserID() + ": InstrumentType: " + instrumentDTO.getInstrumentType().name());
        }

        // get all instruments of USER2
        List<InstrumentDTO> user2Instruments = instrumentController.getAllInstruments(user2Details.getUserID());
        for(InstrumentDTO instrumentDTO: user2Instruments){
            System.out.println("User2 InstID: " + instrumentDTO.getInstrumentID() + ": UserID: " +
                    instrumentDTO.getUserID() + ": InstrumentType: " + instrumentDTO.getInstrumentType().name());
        }

        // get all transaction history
        List<Transaction> user1TransactionList = transactionController.getTransactionHistory(user1Details.getUserID());
        List<Transaction> user2TransactionList = transactionController.getTransactionHistory(user2Details.getUserID());

        System.out.println("Printing list of user1TransactionList: ");
        for(Transaction txn: user1TransactionList){
            System.out.println(txn.toString());
        }

        System.out.println("Printing list of user2TransactionList: ");
        for(Transaction txn: user2TransactionList){
            System.out.println(txn.toString());
        }

    }
}
