package Product;

public class UPIPaymentMode implements PaymentMode{

    @Override
    public boolean makePayment() {
        System.out.println("Payment by UPI");
        return true;
    }
}
