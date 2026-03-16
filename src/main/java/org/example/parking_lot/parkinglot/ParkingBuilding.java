package org.example.parking_lot.parkinglot;

import org.example.parking_lot.Entity.ParkingSpot;
import org.example.parking_lot.Entity.Vehicle;
import org.example.parking_lot.Ticket;

import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel> levels;

    public ParkingBuilding(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    public Ticket allocate(Vehicle vehicle){
        for(ParkingLevel level: levels){
            if(level.hasAvailability(vehicle.getVehicleType())){
                ParkingSpot spot = level.park(vehicle.getVehicleType());
                if(spot != null){
                    Ticket ticket = new Ticket(vehicle, level, spot);
                    System.out.println("Parking allocated at level: "
                                        + level.getLevelNumber()
                                        + " spot: " + spot.getSpotId());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking Full");
    }

    void release(Ticket ticket){
        ticket.getLevel().unPark(ticket.getVehicle().getVehicleType(), ticket.getSpot());
    }
}
