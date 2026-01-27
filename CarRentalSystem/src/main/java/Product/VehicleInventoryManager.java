package Product;

import Product.Enums.VehicleStatus;
import Product.Enums.VehicleType;
import Reservation.Reservation;
import Reservation.ReservationRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleInventoryManager {
    ConcurrentMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<>();
    ConcurrentMap<Integer, List<Integer>> bookings = new ConcurrentHashMap<>();
    ConcurrentMap<Integer, ReentrantLock> vehicleLocks = new ConcurrentHashMap<>();
    ReservationRepository reservationRepository;

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getVehicleId(), vehicle);
    }

    public void setReservationRepository(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public Optional<Vehicle> getVehicle(int vehicleId){
        return Optional.ofNullable(vehicles.get(vehicleId));
    }

    public ReentrantLock lockForVehicle(int vehicleId){
        vehicleLocks.putIfAbsent(vehicleId, new ReentrantLock());
        return vehicleLocks.get(vehicleId);
    }

    public boolean isAvailable(int vehicleId, LocalDate dateFrom, LocalDate dateTo){
        Vehicle vehicle = vehicles.get(vehicleId);

        if(vehicle == null) return false;
        if(vehicle.getVehicleStatus() == VehicleStatus.MAINTAINENCE) return false;

        DateInterval requested = new DateInterval(dateFrom, dateTo);

        List<Integer> reservationIds = bookings.get(vehicleId);
        if(reservationIds == null || reservationIds.isEmpty()) return true;

        for(int reservationId: reservationIds){
            Reservation reservation = reservationRepository.findByID(reservationId).get();
            LocalDate bookedFrom = reservation.getBookedDateFrom();
            LocalDate bookedTill = reservation.getBookedDateTo();

            DateInterval bookedInterval = new DateInterval(bookedFrom, bookedTill);
            if(bookedInterval.isOverlap(requested)) return false;
        }
        return true;
    }

    public boolean reserve(int vehicleId, int reservationId, LocalDate dateFrom, LocalDate dateTo){
        ReentrantLock lock = lockForVehicle(vehicleId);
        lock.lock();

        try{
            if(!isAvailable(vehicleId,dateFrom,dateTo)) return false;
            bookings.putIfAbsent(vehicleId, new ArrayList<>());
            bookings.get(vehicleId).add(reservationId);

            vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.BOOKED);
            return true;
        }
        finally {
            lock.unlock();
        }
    }

    public void release(int vehicleId, int reservationId){
        ReentrantLock lock = lockForVehicle(vehicleId);
        lock.lock();

        try{
            List<Integer> ids = bookings.get(vehicleId);
            if(ids != null){
                ids.remove(Integer.valueOf(reservationId));
            }

            List<Integer> stillBooked = bookings.get(vehicleId);
            if(stillBooked == null || stillBooked.isEmpty()){
                vehicles.get(vehicleId).setVehicleStatus(VehicleStatus.AVAILABLE);
            }
        }
        finally {
            lock.unlock();
        }
    }

    public List<Vehicle> getAvailableVehicles(VehicleType vehicleType, LocalDate dateFrom, LocalDate dateTo){
        return vehicles.values()
                .stream()
                .filter(v-> v.getVehicleType()==vehicleType)
                .filter(v-> isAvailable(v.getVehicleId(), dateFrom, dateTo))
                .collect(Collectors.toList());
    }


}
