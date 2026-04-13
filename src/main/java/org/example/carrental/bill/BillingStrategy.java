package org.example.carrental.bill;

import org.example.carrental.reservation.Reservation;

public interface BillingStrategy {
    Bill generateBill(Reservation reservation);
}
