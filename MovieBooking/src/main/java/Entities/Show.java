package Entities;

import Enums.SeatStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    Movie movie;
    LocalDate showDate;
    LocalTime showTime;
    Map<Integer, SeatStatus> seatStatusMap = new HashMap<>();
    Map<Integer, ReentrantLock> seatLockMap = new HashMap<>();

    public Show(Movie movie, Screen screen, LocalDate showDate, LocalTime showTime
                ){
        this.movie = movie;
        this.showDate = showDate;
        this.showTime = showTime;

        for(Seat seat: screen.getSeats()){
            seatStatusMap.put(seat.getSeatId(), SeatStatus.AVAILABLE);
            seatLockMap.put(seat.getSeatId(), new ReentrantLock());
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public boolean lockSeats(List<Integer> seats){
        List<Integer> sorted = new ArrayList<>(seats);
        Collections.sort(sorted);

        List<ReentrantLock> acquiredLocks = new ArrayList<>();

        try{
            //acquire all locks
            for (int seatId: sorted){
                ReentrantLock lock = seatLockMap.get(seatId);
                lock.lock();
                acquiredLocks.add(lock);
            }

            //validate locks
            for(int seatId: seats){
                if(seatStatusMap.get(seatId) != SeatStatus.AVAILABLE){
                    return false;
                }
            }

            //mark lock
            for(int seatId: seats){
                seatStatusMap.put(seatId, SeatStatus.BOOKED);
            }

            return true;
        }
        finally {
            //release locks
            for(ReentrantLock lock: acquiredLocks){
                lock.unlock();
            }
        }
    }

    public void confirmSeats(List<Integer> seatIds) {
        for (int seatId : seatIds) {
            seatStatusMap.put(seatId, SeatStatus.BOOKED);
        }
    }

    public void releaseSeats(List<Integer> seatIds) {
        for (int seatId : seatIds) {
            seatStatusMap.put(seatId, SeatStatus.AVAILABLE);
        }
    }
}
