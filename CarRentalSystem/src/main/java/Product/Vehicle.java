package Product;

import Product.Enums.VehicleStatus;
import Product.Enums.VehicleType;

public class Vehicle {
    int vehicleId;
    String vehicleNumber;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;
    double dailyRent;

    public Vehicle(int vehicleId, String vehicleNumber, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(double dailyRent) {
        this.dailyRent = dailyRent;
    }
}
