package org.example.PaymentGateway.service;

import org.example.PaymentGateway.enums.InstrumentType;

public class InstrumentServiceFactory {
    public InstrumentService getInstrumentService(InstrumentType instrumentType){
        if(instrumentType == InstrumentType.BANK){
            return new BankService();
        } else if(instrumentType == InstrumentType.CARD){
            return new CardService();
        }

        return null;
    }
}
