package Reservation;

import Product.Enums.VehicleType;
import Product.VehicleInventoryManager;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {
    Map<Integer, Reservation> reservationList;

    public ReservationRepository() {
        this.reservationList = new ConcurrentHashMap<>();
    }

    public Optional<Reservation> findByID(int reservationId){
        return Optional.ofNullable(reservationList.get(reservationId));
    }

    public void save(int reservationId, Reservation reservation){
        reservationList.put(reservationId, reservation);
    }

    public void remove(int reservationId){
         reservationList.remove(reservationId);
    }

    public Map<Integer, Reservation> getAll(){
        return reservationList;
    }
}
