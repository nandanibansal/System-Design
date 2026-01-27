package Billing;

import Reservation.Reservation;

import java.util.concurrent.atomic.AtomicInteger;

public interface BillingStrategy {
    public Bill generateBill(Reservation reservation);
}
