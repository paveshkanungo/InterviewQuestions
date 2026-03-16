package org.example.parking_lot.spotManagers;

import org.example.parking_lot.Entity.ParkingSpot;
import org.example.parking_lot.LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager {
    public TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        super(spots, strategy);
    }
}
