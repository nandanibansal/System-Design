package states;

import Entities.ATM;
import Entities.Card;
import Entities.TransactionType;

public class SelectOptionCard extends ATMState{

    public SelectOptionCard(){
        showOptions();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        switch (transactionType){
            case CASH_WITHDRAWAL:
                atm.setAtmState(new CashWithDrawState());
                break;
            case CHECK_BALANCE:
                atm.setAtmState(new CheckBalanceState());
                break;
            default:
                System.out.println("Invalid Option");
                exit(atm);
        }
    }

    @Override
    public void exit(ATM atmObject){
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

    public void showOptions(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
}
