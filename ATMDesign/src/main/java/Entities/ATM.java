package Entities;

import states.ATMState;
import states.IdleState;

public class ATM {
    private static ATM atmObject = new ATM();

    ATMState atmState;
    private int atmBalance;
    int noOf2k, noOf500, noOf100;

    private ATM() {
    }

    public static ATM getAtmObj(){
        atmObject.setAtmState(new IdleState());
        return atmObject;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOf2k = noOfTwoThousandNotes;
        this.noOf500 = noOfFiveHundredNotes;
        this.noOf100 = noOfOneHundredNotes;
    }

    public int getNoOf2k() {
        return noOf2k;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public int getNoOf100() {
        return noOf100;
    }

    public int getNoOf500() {
        return noOf500;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void deductNoOf2k(int n) {
        noOf2k = noOf2k - n;
    }

    public void deductNoOf100(int n) {
        noOf100 = noOf100 - n;
    }

    public void deductNoOf500(int n) {
        noOf500 = noOf500 - n;
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOf2k);
        System.out.println("500Notes: " + noOf500);
        System.out.println("100Notes: " + noOf100);

    }

}
