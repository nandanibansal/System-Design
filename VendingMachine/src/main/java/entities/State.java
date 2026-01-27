package entities;

import java.util.List;

public abstract class State {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {}

    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {}

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {}

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {}

    public int getChange(int returnMoney) throws Exception {
        return 0;
    }

    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        return null;
    }

    public List<Coin> refundFullAmount(VendingMachine vendingMachine) throws Exception {
        return null;
    }

    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {}

}
