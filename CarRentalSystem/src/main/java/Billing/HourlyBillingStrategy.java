package Billing;

import Product.Vehicle;
import Product.VehicleInventoryManager;
import Reservation.Reservation;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HourlyBillingStrategy implements BillingStrategy{
    VehicleInventoryManager vehicleInventoryManager;
    private final AtomicInteger billIdGenerator = new AtomicInteger(5000);

    @Override
    public Bill generateBill(Reservation reservation) {
        long hours = ChronoUnit.HOURS.between(reservation.getBookedDateFrom(), reservation.getBookedDateTo());
        Vehicle vehicle = vehicleInventoryManager.getVehicle(reservation.getVehicleId()).get();
        double totalBill = hours * vehicle.getDailyRent();

        Bill newBill = new Bill(billIdGenerator.getAndIncrement(), reservation.getReservationId(), totalBill);
        return newBill;
    }
}
