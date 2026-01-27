package Payment;

import Billing.Bill;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class UPIPaymentStrategy implements PaymentStrategy {

    private final AtomicInteger paymentIdGenerator = new AtomicInteger(5000);

    @Override
    public Payment getPayment(Bill bill, double amountToPay) {
        int paymentId = paymentIdGenerator.getAndIncrement();
        Payment payment = new Payment(paymentId, bill.getBillId(), amountToPay, PaymentMode.UPI, new Date());
        bill.setBillPaid(true);
        return payment;
    }
}
