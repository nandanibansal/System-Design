package Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {
    int screenId;
    List<Seat> seats;
    Map<LocalDate, List<Show>> showsByDate = new HashMap<>();

    public Screen(int screenId, List<Seat> seats){
        this.screenId = screenId;
        this.seats = seats;
    }

    public int getScreenId() {
        return screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addShow(Show show){
        showsByDate.computeIfAbsent(show.getShowDate(), k -> new ArrayList<>()).add(show);
    }

    public List<Show> getShowsByDate(LocalDate date) {
        return showsByDate.get(date);
    }

}
