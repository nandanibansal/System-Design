package Payment;

public class UPIPayment implements Payment{

    @Override
    public boolean pay(double amount){
        System.out.println(amount+" payment received on UPI");
        return true;
    }
}
