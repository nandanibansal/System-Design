package Billing;

import Product.Vehicle;
import Product.VehicleInventoryManager;
import Reservation.Reservation;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DailyBillingStrategy implements BillingStrategy{
    VehicleInventoryManager vehicleInventoryManager;
    private final AtomicInteger billIdGenerator = new AtomicInteger(5000);

    public DailyBillingStrategy(VehicleInventoryManager vehicleInventoryManager) {
        this.vehicleInventoryManager = vehicleInventoryManager;
    }

    @Override
    public Bill generateBill(Reservation reservation) {
        long days = ChronoUnit.DAYS.between(reservation.getBookedDateFrom(), reservation.getBookedDateTo());
        Vehicle vehicle = vehicleInventoryManager.getVehicle(reservation.getVehicleId()).get();
        double totalBill = days * vehicle.getDailyRent();

        Bill newBill = new Bill(billIdGenerator.getAndIncrement(), reservation.getReservationId(), totalBill);
        return newBill;
    }
}
