import Billing.*;
import Payment.*;
import Product.Enums.VehicleType;
import Product.Vehicle;
import Product.VehicleInventoryManager;
import Reservation.*;

import java.time.LocalDate;
import java.util.List;

public class Store {
    int storeId;
    Location storeLocation;
    BillingManager billingManager;
    PaymentManager paymentManager;
    ReservationManager reservationManager;
    VehicleInventoryManager vehicleInventoryManager;

    public Store(int storeId, Location location) {

        this.storeId = storeId;
        this.storeLocation = location;
        this.vehicleInventoryManager = new VehicleInventoryManager();
        this.billingManager = new BillingManager(new DailyBillingStrategy(vehicleInventoryManager));
        this.paymentManager = new PaymentManager(new UPIPaymentStrategy());
        this.reservationManager = new ReservationManager(vehicleInventoryManager);
    }

    public List<Vehicle> getVehicles(VehicleType type, LocalDate dateFrom, LocalDate dateTo){
       return vehicleInventoryManager.getAvailableVehicles(type, dateFrom, dateTo);
    }

    public Reservation createReservation(int vehicleId, User user, LocalDate from, LocalDate to,
                                         ReservationType type) throws Exception {
        return reservationManager.createReservation(vehicleId, type, from, to, user);
    }

    public void cancelReservation(int reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId) {
        reservationManager.startTrip(reservationId);
    }

    public void submitVehicle(int reservationId) {
        reservationManager.submitVehicle(reservationId);
    }

    public Bill generateBill(int reservationId, BillingStrategy billingStrategy) {
        Reservation r = reservationManager.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        billingManager.setBillingStrategy(billingStrategy);
        return billingManager.generateBill(r);
    }

    public Payment makePayment(Bill bill, PaymentStrategy paymentStrategy, double paymentAmount) {

        paymentManager.setPaymentStrategy(paymentStrategy);
        Payment payment = paymentManager.makePayment(bill, paymentAmount);

        if (!bill.isBillPaid()) {
            throw new RuntimeException("Payment failed");
        }

        // NOW we can safely remove the reservation from the repo
        reservationManager.remove(bill.getReservationId());
        return payment;
    }

    public VehicleInventoryManager getInventory() {
        return vehicleInventoryManager;
    }

    public int getStoreId() {
        return storeId;
    }
}
