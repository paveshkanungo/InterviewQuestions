package org.example.BookMyShow.entities;

import org.example.BookMyShow.enums.SeatStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    private final Movie movie;
    private final LocalDate showDate;
    private final LocalTime showTime;

    private final Map<Integer, SeatStatus> seatStatusMap = new HashMap<>();
    private final Map<Integer, ReentrantLock> seatLocks = new HashMap<>();

    public Show(Movie movie,  Screen screen, LocalDate showDate, LocalTime showTime) {
        this.movie = movie;
        this.showDate = showDate;
        this.showTime = showTime;

        for(Seat seat: screen.getSeats()){
            seatStatusMap.put(seat.getSeatId(), SeatStatus.AVAILABLE);
            seatLocks.put(seat.getSeatId(), new ReentrantLock());
        }
    }

    public Movie getMovie(){
        return movie;
    }

    public LocalDate getShowDate(){
        return showDate;
    }

    public LocalTime getStartTime(){
        return showTime;
    }

    public boolean lockSeats(List<Integer> seatIds){
        List<Integer> sorted = new ArrayList<>(seatIds);

        // sorting to avoid deadlock scenario
        Collections.sort(sorted);

        List<ReentrantLock> acquiredLocks = new ArrayList<>();

        try{
            // Phase 1: Acquire all Locks
            for(int seatId: sorted){
                ReentrantLock lock = seatLocks.get(seatId);
                lock.lock();
                acquiredLocks.add(lock);
            }

            // Phase 2: validate Availability
            for(int seatId: sorted){
                if(seatStatusMap.get(seatId) != SeatStatus.AVAILABLE){
                    return false;
                }
            }

            // Phase 3: mark Locked
            for(int seatId: sorted){
                seatStatusMap.put(seatId, SeatStatus.LOCKED);
            }

            return true;
        } finally {

            // Phase 4: Release Locks
            for(ReentrantLock lock: acquiredLocks){
                lock.unlock();
            }
        }
    }

    public void confirmSeats(List<Integer> seatIds){
        for(int seatId: seatIds){
            seatStatusMap.put(seatId, SeatStatus.BOOKED);
        }
    }

    public void releaseSeats(List<Integer> seatIds){
        for(int seatId: seatIds){
            seatStatusMap.put(seatId, SeatStatus.AVAILABLE);
        }
    }


}
