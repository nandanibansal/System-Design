package Billing;

public class Bill {
    int billId;
    int reservationId;
    double totalBillAmount;
    boolean isBillPaid;

    public Bill(int billId, int reservationId, double totalBillAmount){
        this.billId = billId;
        this.totalBillAmount = totalBillAmount;
        this.reservationId = reservationId;
        this.isBillPaid = false;
    }

    public int getBillId() {
        return billId;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setBillPaid(boolean billPaid) {
        isBillPaid = billPaid;
    }
}
