package Product;

public class CardPaymentMode implements PaymentMode{
    @Override
    public boolean makePayment() {
        System.out.println("Payment by card");
        return true;
    }
}
