package Payment;

public class CashPayment implements Payment {
    @Override
    public boolean pay(double amount){
        System.out.println(amount+" cash received");
        return true;
    }
}
