package AmountWithdrawal;

import Entities.ATM;

public class OneHundreadCashWithdrawal extends CashWithdrawalProcess{
    public OneHundreadCashWithdrawal(CashWithdrawalProcess cashWithdrawalProcess) {
        super(cashWithdrawalProcess);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoOf100()){
            atm.deductNoOf100(required);
        }
        else if(required > atm.getNoOf100()){
            atm.deductNoOf100(atm.getNoOf100());
            balance = balance + (required - atm.getNoOf100()) * 100;
        }

        if(balance!=0){
            super.withdraw(atm, balance);
        }
    }
}
