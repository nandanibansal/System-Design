//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("###### Template Method Design Pattern ######");

        // Bank Transfer
        System.out.println("===== Bank Transfer =====");
        PaymentFlow bankTransfer = new BankTransfer();
        bankTransfer.sendMoney(); // Template method
        bankTransfer.logTransaction(); // Common method

        // Merchant Payment
        System.out.println("===== Merchant Payment =====");
        PaymentFlow merchantPayment = new MerchantPayment();
        merchantPayment.sendMoney(); // Template method
        merchantPayment.logTransaction(); // Common method
    }

}