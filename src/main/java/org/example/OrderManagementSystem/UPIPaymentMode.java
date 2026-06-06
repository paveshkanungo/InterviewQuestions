package org.example.OrderManagementSystem;

public class UPIPaymentMode implements PaymentMode{
    @Override
    public boolean makePayment() {
        return true;
    }
}
