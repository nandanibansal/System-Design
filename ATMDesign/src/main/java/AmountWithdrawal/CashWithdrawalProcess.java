package AmountWithdrawal;

import Entities.ATM;

public class CashWithdrawalProcess {
    CashWithdrawalProcess nextCashWithdrawalProcessor;

    CashWithdrawalProcess(CashWithdrawalProcess cashWithdrawalProcess){
        this.nextCashWithdrawalProcessor = cashWithdrawalProcess;
    }
    public void withdraw(ATM atm, int remainingMoney){
        if(nextCashWithdrawalProcessor!=null)
            nextCashWithdrawalProcessor.withdraw(atm, remainingMoney);
    }
}
