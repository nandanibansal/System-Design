package Entities;

import java.util.List;
import java.util.UUID;

public class Booking {
    UUID bookingId;
    User user;
    Payment payment;
    Show show;
    List<Integer> seats;

    public Booking(User user, Show show, List<Integer> seats, Payment payment) {
        this.bookingId = UUID.randomUUID();
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Payment getPayment() {
        return payment;
    }

}
