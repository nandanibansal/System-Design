package Reservation;

import Product.VehicleInventoryManager;

import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
    ReservationRepository reservationRepository;
    VehicleInventoryManager vehicleInventoryManager;

    private final AtomicInteger reservationIdGenerator = new AtomicInteger(20000);

    public ReservationManager(VehicleInventoryManager vehicleInventoryManager){
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationRepository = new ReservationRepository();
        this.vehicleInventoryManager.setReservationRepository(reservationRepository);
    }

    public Reservation createReservation(int vehicleId, ReservationType reservationType, LocalDate bookFrom, LocalDate bookTo, User user){
        int reservationId = reservationIdGenerator.getAndIncrement();
        boolean reserve = vehicleInventoryManager.reserve(vehicleId,reservationId,bookFrom,bookTo);

        if(!reserve){
            throw new RuntimeException("Vehicle not available");
        }

        Reservation reservation = new Reservation(vehicleId, reservationId, user.getUserId(), bookFrom, bookTo, reservationType);
        reservationRepository.save(reservationId, reservation);
        return reservation;
    }

    public void cancelReservation(int reservationId){
        Optional<Reservation> opt = reservationRepository.findByID(reservationId);

        if(!opt.isPresent()){
            throw new RuntimeException("Reservation not found.");
        }

        Reservation r = opt.get();
        r.setReservationStatus(ReservationStatus.CANCELLED);
        vehicleInventoryManager.release(r.getVehicleId(), reservationId);
        reservationRepository.remove(reservationId);
    }

    public void startTrip(int reservationId){
        Reservation r = reservationRepository.findByID(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found."));
        r.setReservationStatus(ReservationStatus.IN_USE);
    }

    public void submitVehicle(int reservationId){
        Reservation r = reservationRepository.findByID(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found."));
        r.setReservationStatus(ReservationStatus.COMPLETED);

        vehicleInventoryManager.release(r.getVehicleId(), reservationId);
    }

    public void remove(int reservationId){
        reservationRepository.remove(reservationId);
    }

    public Optional<Reservation> findById(int reservationId){
        return reservationRepository.findByID(reservationId);
    }
}
