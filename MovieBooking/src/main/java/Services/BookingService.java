package Services;

import Entities.Booking;
import Entities.Payment;
import Entities.Show;
import Entities.User;
import Enums.PaymentStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    Map<UUID, Booking> bookingMap = new HashMap<>();

    public Booking book(User user, Show show, List<Integer> seats){
        if(!show.lockSeats(seats)){
            throw new RuntimeException("Seats not available");
        }

        Payment payment = new Payment(PaymentStatus.COMPLETED);

        if(payment.getStatus() == PaymentStatus.COMPLETED){
            show.confirmSeats(seats);
            Booking booking = new Booking(user, show, seats, payment);
            bookingMap.put(booking.getBookingId(), booking);
            return booking;
        }
        else {
            show.releaseSeats(seats);
            throw new RuntimeException("Payment failed");
        }
    }

    public Booking getBooking(UUID bookingId) {
        return bookingMap.get(bookingId);
    }

    public List<Booking> getBookingsForUser(User user) {
        return bookingMap.values().stream().filter(b-> b.getUser().equals(user)).toList();
    }

    public Booking deleteBooking(UUID bookingId){
        return bookingMap.remove(bookingId);
    }
}
