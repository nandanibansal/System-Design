package Payment;

import Billing.Bill;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PaymentManager {
    ConcurrentMap<Integer, Payment> payments;
    public final AtomicInteger paymentIdGenerator = new AtomicInteger();
    PaymentStrategy paymentStrategy;

    public PaymentManager(PaymentStrategy paymentStrategy){
        this.payments = new ConcurrentHashMap<>();
        this.paymentStrategy = paymentStrategy;
    }

    public Payment makePayment(Bill bill, double amount){
        Payment payment = paymentStrategy.getPayment(bill, amount);
        payments.put(payment.getPaymentId(), payment);
        return payment;
    }

    public List<Payment> getPaymentsForBill(int billId){
        return payments.values().stream()
                .filter(payment -> payment.getBillId() == billId)
                .toList();
    }

    public Optional<Payment> getPayment(int paymentId) {
        return Optional.ofNullable(payments.get(paymentId));
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
