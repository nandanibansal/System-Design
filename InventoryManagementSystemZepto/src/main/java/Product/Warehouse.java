package Product;

import java.util.Map;

public class Warehouse {
    public Inventory inventory;
    public Address address;

    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndCountMap)
    {
        inventory.removeItems(productCategoryAndCountMap);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap){
        //it will update the items in the inventory based upon product category.
    }
}
