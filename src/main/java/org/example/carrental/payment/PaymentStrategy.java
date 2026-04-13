package org.example.carrental.payment;

import org.example.carrental.bill.Bill;

public interface PaymentStrategy {
    Payment processPayment(Bill bill, double PaymentAmount);
}
