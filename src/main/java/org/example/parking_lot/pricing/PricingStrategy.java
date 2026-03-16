package org.example.parking_lot.pricing;

import org.example.parking_lot.Ticket;

public interface PricingStrategy {
    double calculate(Ticket ticket);
}
