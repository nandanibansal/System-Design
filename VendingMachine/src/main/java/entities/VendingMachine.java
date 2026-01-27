package entities;

import states.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State currentState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine() {
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
        this.currentState = new IdleState();
    }
    public State getVendingMachineState() {
        return currentState;
    }
    public void setVendingMachineState(State state) {
        this.currentState = state;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public List<Coin> getCoinList() {
        return coinList;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

}
