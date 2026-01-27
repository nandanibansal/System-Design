package states;

import AmountWithdrawal.CashWithdrawalProcess;
import AmountWithdrawal.FiveHundreadCashWithdrawal;
import AmountWithdrawal.OneHundreadCashWithdrawal;
import AmountWithdrawal.TwoThousandCashWithdrawal;
import Entities.ATM;
import Entities.Card;

public class CashWithDrawState extends ATMState{

    public CashWithDrawState(){
        System.out.println("We are in Cash Withdraw State");
    }

    @Override
    public void cashWithdraw(ATM atm, Card card, int withDrawMonay){
        if(withDrawMonay > atm.getAtmBalance()){
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atm);
        }
        else if(card.getBankBalance() < withDrawMonay){
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atm);
        }
        else {
            card.deductBankAccountBalance(withDrawMonay);
            atm.deductATMBalance(withDrawMonay);
            CashWithdrawalProcess withdrawProcessor =
                    new TwoThousandCashWithdrawal(new FiveHundreadCashWithdrawal(new OneHundreadCashWithdrawal(null)));

            withdrawProcessor.withdraw(atm, withDrawMonay);
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
