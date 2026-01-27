package Payment;

import java.util.Date;

public class Payment {
    int paymentId;
    int billId;
    double amountPaid;
    PaymentMode paymentMode;
    Date paymentDate;

    public Payment(int paymentId, int billId, double amountPaid, PaymentMode paymentMode, Date paymentDate
    ){
        this.paymentId = paymentId;
        this.billId = billId;
        this.amountPaid = amountPaid;
        this.paymentMode = paymentMode;
        this.paymentDate = paymentDate;
    }

    public int getBillId() {
        return billId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public Date getPaymentDate() { return paymentDate; }
}
