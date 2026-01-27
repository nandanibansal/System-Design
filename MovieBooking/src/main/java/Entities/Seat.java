package Entities;

import Enums.SeatCategory;

public class Seat {
    int seatId;
    SeatCategory seatCategory;

    public Seat(int seatId, SeatCategory seatCategory){
        this.seatId = seatId;
        this.seatCategory =seatCategory;
    }

    public int getSeatId() {
        return seatId;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }
}
