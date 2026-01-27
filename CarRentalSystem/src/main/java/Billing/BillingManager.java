package Billing;

import Reservation.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BillingManager {
    ConcurrentMap<Integer, Bill> bills = new ConcurrentHashMap<>();
    BillingStrategy billingStrategy;

    public BillingManager(BillingStrategy billingStrategy){
        this.billingStrategy = billingStrategy;
    }

    public Bill generateBill(Reservation reservation) {

        Bill bill = billingStrategy.generateBill(reservation);
        bills.put(bill.getBillId(), bill);
        return bill;
    }

    public Optional<Bill> getBill(int billId) {
        return Optional.ofNullable(bills.get(billId));
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

}
