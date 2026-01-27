package states;

import entities.Coin;
import entities.Item;
import entities.State;
import entities.VendingMachine;

import java.util.List;

public class DispensingState extends State {

    public DispensingState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Currently Vending machine is in DispensingState");
        dispenseProduct(vendingMachine, codeNumber);
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public List<Coin> refundFullAmount(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }
}
