package Entities;

public class BankAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withDrawBalance(int amount) {
        balance = balance - amount;
    }
}
