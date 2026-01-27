import Product.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProductDeliveryManagementSystem {
    public static void main(String[] args) {
        ProductDeliveryManagementSystem mainObj = new ProductDeliveryManagementSystem();
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(mainObj.addWarehouseAndItsInventory());

        List<User> userList = new ArrayList<>();
        userList.add(mainObj.createUser());

        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userList, warehouseList);
        mainObj.runDeliveryFlow(productDeliverySystem, 1);

    }

    private Warehouse addWarehouseAndItsInventory(){
        Warehouse warehouse = new Warehouse();

        Inventory inventory = new Inventory();

        inventory.addCategory(0001,  "Peppsii Large Cold Drink" , 100);
        inventory.addCategory(0004, "Doovee small Soap" , 50);

        Product product1 = new Product();
        product1.productId = 1;
        product1.productName = "Peepsii";

        Product product2 = new Product();
        product2.productId = 2;
        product2.productName = "Peepsii";

        Product product3 = new Product();
        product3.productId = 3;
        product3.productName = "Doovee";

        inventory.addProduct(product1, 0001);
        inventory.addProduct(product2, 0001);
        inventory.addProduct(product3, 0004);

        warehouse.inventory = inventory;
        return warehouse;
    }

    private User createUser(){
        User user = new User();
        user.userId = 1;
        user.name = "SJ";
        user.address = new Address(230011, "city", "state");
        return user;
    }

    private  void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId){
        User user = productDeliverySystem.getUser(userId);
        Warehouse warehouse = productDeliverySystem.getWarehouse(new NearestWarehouseSelectionStrategy());

        Inventory inventory = productDeliverySystem.getInventory(warehouse);
        ProductCategory productCategoryIWantToOrder = null;

        for(ProductCategory productCategory : inventory.productCategoryList){
            if(productCategory.categoryName.equals("Peppsii Large Cold Drink")){
                productCategoryIWantToOrder = productCategory;
            }
        }

        productDeliverySystem.addProductToCart(user, productCategoryIWantToOrder, 2);
        Order order = productDeliverySystem.placeOrder(user, warehouse);
        productDeliverySystem.checkout(order);

    }

}