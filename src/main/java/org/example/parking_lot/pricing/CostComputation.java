package org.example.parking_lot.pricing;

import org.example.parking_lot.Ticket;

public class CostComputation {
    private final PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double compute(Ticket ticket) {
        return pricingStrategy.calculate(ticket);
    }
}
