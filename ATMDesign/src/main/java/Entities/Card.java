package Entities;

public class Card {
    private final int pin;
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    BankAccount bankAccount;

    public Card(String cardOwner, int pin, BankAccount bankAccount) {
        this.holderName = cardOwner;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }
    
    public boolean isCorrectPINEntered(int PIN_NUMBER) {

        if (pin == PIN_NUMBER) {
            return true;
        }
        return false;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getBankBalance() {
        return bankAccount.getBalance();
    }

    public void deductBankAccountBalance(int amount) {
        bankAccount.withDrawBalance(amount);
    }
}
