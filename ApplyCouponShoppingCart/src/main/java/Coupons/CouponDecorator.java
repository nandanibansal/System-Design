package Coupons;

import Product.Product;

public abstract class CouponDecorator extends Product {
    Product product;
    int discountPercentage;

    public CouponDecorator(Product product, int discountPercentage){
        super(product.getName(), product.originalPrice, product.getType());
        this.product = product;
        this.discountPercentage = discountPercentage;
    }
}
