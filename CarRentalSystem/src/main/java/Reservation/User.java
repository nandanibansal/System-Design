package Reservation;

public class User {
    int userId;
    String userName;
    String driverLicenceNumber;

    public User(int userId, String userName, String driverLicenceNumber){
        this.userId = userId;
        this.userName = userName;
        this.driverLicenceNumber = driverLicenceNumber;
    }

    public int getUserId() {
        return userId;
    }
}
