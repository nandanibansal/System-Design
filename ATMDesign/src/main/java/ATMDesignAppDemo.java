import Entities.*;

public class ATMDesignAppDemo {
    User user;
    ATM atm;
    public static void main(String[] args) {
        ATMDesignAppDemo atmRoom = new ATMDesignAppDemo();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 130);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getAtmState().cashWithdraw(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printCurrentATMStatus();
    }

    private void initialize(){
        atm = ATM.getAtmObj();
        atm.setAtmBalance(3500, 1, 2, 5);
        this.user = createUser();
    }

    private User createUser(){
        User user1 = new User();
        user1.setCard(getCard());
        return user1;
    }

    private Card getCard(){
        Card card = new Card("Nandani", 1334, getBankAccount());
        return card;
    }

    private BankAccount getBankAccount(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(5000);

        return bankAccount;
    }
}