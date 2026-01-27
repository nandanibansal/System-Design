package Payment;

import Billing.Bill;

public interface PaymentStrategy {
    public Payment getPayment(Bill bill, double amountToPay);
}
