package AmountWithdrawal;

import Entities.ATM;

public class FiveHundreadCashWithdrawal extends CashWithdrawalProcess{

    public FiveHundreadCashWithdrawal(CashWithdrawalProcess cashWithdrawalProcess) {
        super(cashWithdrawalProcess);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOf500()){
            atm.deductNoOf500(required);
        }
        else if(required > atm.getNoOf500()){
            atm.deductNoOf500(atm.getNoOf500());
            balance = balance + (required - atm.getNoOf500()) * 500;
        }

        if(balance!=0){
            super.withdraw(atm, balance);
        }
    }
}
