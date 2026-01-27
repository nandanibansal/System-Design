import Coupons.*;
import Product.*;

import java.util.*;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart(){
        this.productList = new ArrayList<>();
    }

    public void addToCart(Product product){
        Product productWithEligibleDiscount =
                new TypeCouponDecorator(new PercentageCouponDecorator(product, 20), 10);
        productList.add(productWithEligibleDiscount);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(Product product: productList){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
