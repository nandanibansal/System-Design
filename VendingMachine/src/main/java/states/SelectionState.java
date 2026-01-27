package states;

import entities.Coin;
import entities.Item;
import entities.State;
import entities.VendingMachine;

import java.util.List;

public class SelectionState extends State {

    public SelectionState(){
        System.out.println("Currently Vending machine is in SelectionState");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        Item item = machine.getInventory().getItem(codeNumber);
        int paidByUser=0;

        for(Coin coin: machine.getCoinList()){
            paidByUser += coin.value;
        }

        if(paidByUser < item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullAmount(machine);
            throw new Exception("insufficient amount");
        }

        else if(paidByUser >= item.getPrice()){
            if(paidByUser > item.getPrice())
                getChange(paidByUser-item.getPrice());
            machine.setVendingMachineState(new DispensingState(machine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;
    }

    @Override
    public List<Coin> refundFullAmount(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

}
