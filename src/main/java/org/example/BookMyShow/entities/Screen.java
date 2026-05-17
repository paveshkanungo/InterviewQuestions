package org.example.BookMyShow.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {
    private final String screenId;
    private final List<Seat> seats;
    private final Map<LocalDate, List<Show>> showsByDate = new HashMap<>();

    public Screen(String screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }

    public String getScreenId() {
        return screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addShow(Show show){
        showsByDate
                .computeIfAbsent(show.getShowDate(), d -> new ArrayList<>())
                .add(show);
    }

    public List<Show> getShows(LocalDate date){
        return showsByDate.getOrDefault(date, List.of());
    }
}
