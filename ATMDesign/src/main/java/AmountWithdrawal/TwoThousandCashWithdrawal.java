package AmountWithdrawal;

import Entities.ATM;

public class TwoThousandCashWithdrawal extends CashWithdrawalProcess{

    public TwoThousandCashWithdrawal(CashWithdrawalProcess nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNoOf2k()){
            atm.deductNoOf2k(required);
        }
        else if(required > atm.getNoOf2k()){
            atm.deductNoOf2k(atm.getNoOf2k());
            balance = balance + (required - atm.getNoOf2k()) * 2000;
        }

        if(balance!=0){
            super.withdraw(atm, balance);
        }
    }
}
