package org.example.parking_lot.spotManagers;

import org.example.parking_lot.Entity.ParkingSpot;
import org.example.parking_lot.LookupStrategy.ParkingSpotLookupStrategy;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager {
    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy) {
        super(spots, strategy);
    }
}
