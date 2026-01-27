package Reservation;

import java.time.LocalDate;

public class Reservation {
    int vehicleId;
    int reservationId;
    int userId;
    LocalDate bookedDateFrom;
    LocalDate bookedDateTo;
    ReservationType reservationType;
    ReservationStatus reservationStatus;

    public Reservation(int vehicleId, int reservationId, int userId, LocalDate bookedDateFrom, LocalDate bookedDateTo, ReservationType reservationType){
        this.vehicleId = vehicleId;
        this.reservationId = reservationId;
        this.userId = userId;
        this.bookedDateFrom = bookedDateFrom;
        this.bookedDateTo = bookedDateTo;
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    public LocalDate getBookedDateFrom() {
        return bookedDateFrom;
    }

    public LocalDate getBookedDateTo() {
        return bookedDateTo;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public int getReservationId() {
        return reservationId;
    }
}
