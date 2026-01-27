package Product;

import java.util.List;

public class ProductDeliverySystem {
    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    public ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList){
        userController = new UserController(userList);
        warehouseController = new WarehouseController(warehouseList , null);
        orderController = new OrderController();
    }

    public User getUser(int userId){
        return userController.getUser(userId);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);

    }

    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;

    }

    public void addProductToCart(User user, ProductCategory product, int count){
        System.out.println("Added product category: "+ product.categoryName + " to cart.");
        Cart cart = user.getUserCart();
        cart.addItemInCart(product.categoryId, count);
    }

    public Order placeOrder(User user, Warehouse warehouse){
        System.out.println("Order placed for: "+ warehouse.inventory.productCategoryList.get(0).categoryName);
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.checkOut();
    }
}
