package org.example.PaymentGateway.service;

import org.example.PaymentGateway.dto.InstrumentDTO;

public class Processor {
    public boolean processPayment(
            InstrumentDTO senderInstrument,
            InstrumentDTO receiverInstrument) {

        System.out.println("Payment processed successfully.");
        return true;
    }
}
