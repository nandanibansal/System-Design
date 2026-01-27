package states;

import entities.Item;
import entities.State;
import entities.VendingMachine;

import java.util.ArrayList;

public class IdleState extends State {

    public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine vendingMachine){
        System.out.println("Currently Vending machine is in IdleState");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception{
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception{
        vendingMachine.getInventory().addItem(item, codeNumber);
    }
}
