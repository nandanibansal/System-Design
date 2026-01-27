package Product;

import java.util.*;

public class OrderController {
    List<Order> orderList;
    Map<Integer, List<Order>> userIDVsOrders;

    OrderController(){
        orderList = new ArrayList<>();
        userIDVsOrders = new HashMap<>();
    }

    public Order createNewOrder(User user, Warehouse warehouse) {
        Order order = new Order(user, warehouse);
        orderList.add(order);

        if (userIDVsOrders.containsKey(user.userId)) {
            List<Order> userOrders = userIDVsOrders.get(user.userId);
            userOrders.add(order);
            userIDVsOrders.put(user.userId, userOrders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIDVsOrders.put(user.userId, userOrders);
        }
        return order;
    }

    //remove order
    public void removeOrder(Order order){
        orderList.remove(order);
        for(Map.Entry<Integer, List<Order>> map: userIDVsOrders.entrySet()){
            if(map.getValue().contains(order)){
                List<Order> orders = map.getValue();
                if(orders.size() == 1){
                    userIDVsOrders.remove(map);
                }
                else {
                    orders.remove(order);
                    userIDVsOrders.put(map.getKey(), orders);
                }
            }
        }
    }

    public List<Order> getOrderByCustomerId(int userId){
        return userIDVsOrders.get(userId);
    }

    public Order getOrderByOrderId(int orderId){
        return orderList.get(orderId);
    }

}
